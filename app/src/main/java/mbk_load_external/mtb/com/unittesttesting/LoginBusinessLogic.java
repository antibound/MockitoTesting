package mbk_load_external.mtb.com.unittesttesting;

import com.google.gson.Gson;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import mbk_load_external.mtb.com.unittesttesting.events.LoginEvent;
import mbk_load_external.mtb.com.unittesttesting.events.ServiceResultEvent;
import mbk_load_external.mtb.com.unittesttesting.models.ErrorModel;
import mbk_load_external.mtb.com.unittesttesting.models.User;

/**
 * Created by Frank on 3/7/2016.
 * all the business logic for login screen
 */
@SuppressWarnings({"AssignmentToStaticFieldFromInstanceMethod", "ClassWithOnlyPrivateConstructors", "ClassWithTooManyMethods", "MagicNumber", "StaticNonFinalField", "SameParameterValue"})
public class LoginBusinessLogic {
    private EventBus mEventBus;
    private static LoginBusinessLogic instance = null;
    IAPIService apiServiceTask;
    private int event;

    public IAPIService getApiServiceTask() {
        return apiServiceTask;
    }

    public void setApiServiceTask(IAPIService apiServiceTask) {
        this.apiServiceTask = apiServiceTask;
    }

    public static LoginBusinessLogic getInstance() {
        if (instance == null) {
            instance = new LoginBusinessLogic();
        }
        return instance;
    }

    public static LoginBusinessLogic getInstance(IAPIService apiServiceTask) {
        if (instance == null) {
            instance = new LoginBusinessLogic();
            apiServiceTask.setServiceRequest(new ServiceRequest());
            instance.apiServiceTask = apiServiceTask;
        }
        return instance;
    }

    public LoginBusinessLogic(){

    }

    public void setContextEvent() {
        mEventBus = EventBus.getDefault();
        if (!mEventBus.isRegistered(this)) {
            mEventBus.register(this);
        }
    }

    public void setContextEvent(int eventType) {
        mEventBus = EventBus.getDefault();
        if (!mEventBus.isRegistered(this)) {
            mEventBus.register(this);
        }
        this.event = eventType;
    }

    public void doLogin(String username, String passcode, boolean isRememberUserId, String rsaJsonString, JSONObject deviceInfo) {
        JSONObject jObj = new JSONObject();

        try {
            jObj.put("userId", username);
            jObj.put("Passcode", passcode);
            doLogin(jObj, isRememberUserId, rsaJsonString, deviceInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to invoke webservice call
     *
     * @param deviceInfo
     * @throws Exception
     */
    protected void doLogin(JSONObject jObj, boolean isRememberUserId, String rsaJsonString, JSONObject deviceInfo) {
        apiServiceTask.getServiceRequest().buildUrl("auth");
        apiServiceTask.getServiceRequest().setParams(jObj.toString());
        apiServiceTask.getServiceRequest().setReqType(ServiceRequest.RequestType.post);
        apiServiceTask.execute();
    }

    /**
     * method to receive event from webservice call
     *
     * @param event - ServiceResult Call back
     */
    @SuppressWarnings("unused")
    @Subscribe
    public void onEvent(ServiceResultEvent event) {
        switch (event.event) {
            case success:
                // last parameter 1 is to represent web service output to controller
                handleSuccess(event);
                break;
            case failed:
                handleLoginError(event.result);
                break;
            case cancelled:
                mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_CANCELLE, event.result));
                break;
            case error:
                if(event.originatorEvent != LoginEvent.TYPE_TOUCH_TOKEN_DELETE) {
                    mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_ERROR, event.result));
                }
                break;
            default:
                break;
        }
        mEventBus.unregister(this);
    }

    private void handleSuccess(ServiceResultEvent event) {
           User user = new Gson().fromJson(event.result, User.class);
                    handleLoginSuccess(user, false);
    }

    /**
     * handling the success scenario for login
     *
     * @param user - Passing response to store data in preferneces
     */
    private void handleLoginSuccess(User user, boolean isTouchLogin) {
        mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_SUCCESS, user));
    }

    /**
     * This method will be called when we get the error reponse
     */
    private void handleLoginError(String error) {
        ErrorModel signInError = new Gson().fromJson(error, ErrorModel.class);
        int statusCode = signInError.getMTBStatusCode();
        String errMsg;
        //TODO Needs to be checked for replacing that star in errroMsg
        if (statusCode == 40022) {   //Included code to handle special character ErrorMsg in ChangePasscode
            errMsg = signInError.getUserMessage();
        } else {
            errMsg = signInError.getUserMessage().replace("*", "").replace("\"", "");
        }
        if(statusCode == 40172 || statusCode == 40173){
            mEventBus.post(new LoginEvent(LoginEvent.TYPE_REMOVED_USERNAME,true));
        }else if(statusCode == 40174){
            mEventBus.post(new LoginEvent(LoginEvent.TYPE_REMOVED_USERNAME,true));
        }

        if (statusCode == 40001 || statusCode == 40002 || statusCode == 40003 ||
                statusCode == 40101 || statusCode == 40102 || statusCode == 40103 ||
                statusCode == 40109 || statusCode == 40110 ||
                statusCode == 40302 || statusCode == 40400) {
            mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, statusCode, errMsg, false, false));
        } else if (statusCode == 40108 || statusCode == 40106) {
            mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, statusCode, errMsg, true, false));
        }
        //Go through Setup RSA Security questions flow
        else if (statusCode == 40165) {
            mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, statusCode, errMsg, false, ""));
        }
        //Go through the temporary/expiry pass code change
        else if (statusCode == 40105 || statusCode == 40107) {
            mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, statusCode, errMsg, false, ""));
        } else if (statusCode == 40301 || statusCode == 40104 || statusCode == 40171) {
            // do the change here for spannable (hyperlink)
            /***
             * 40107 - Html a href  Link text comes in response,40171 DSA Html href link comes in response, so 40171 is added to fix defect 2611.
             */
            mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, statusCode, errMsg, false, true));
        } else {
            mEventBus.postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, statusCode, errMsg, false, false));
        }
    }
}
