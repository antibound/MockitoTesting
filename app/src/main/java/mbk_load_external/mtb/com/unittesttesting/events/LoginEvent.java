package mbk_load_external.mtb.com.unittesttesting.events;

import mbk_load_external.mtb.com.unittesttesting.models.User;

/**
 * Created by Frank
 */
@SuppressWarnings("SameParameterValue")
public class LoginEvent {
    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_LOGIN = 7;
    public static final int TYPE_CANCELLE = 8;
    public static final int TYPE_ERROR = 9;
    public static final int TYPE_TOUCH_TOKEN_DELETE = 613;
    public static final int TYPE_REMOVED_USERNAME = 615;

    public final int event;
    public String url;
    public boolean remeberUser;
    public String rsaJsonString;
    public boolean removed;

    public int mtbStstusCode;
    public String errorMsg;
    public  boolean show;
    public boolean span;
    public User userModel;

    /**
     * Event for success login response
     * @param event
     * @param userModel
     *
     */
    public LoginEvent(int event, User userModel)
    {
        this.event = event;
        this.userModel = userModel;
    }

    /**
     *events for Success login response
     * @param event
     * @param mtbStstusCode
     * @param errorMsg
     * @param show
     */

    public LoginEvent(int event, int mtbStstusCode,String errorMsg, boolean show,boolean span){
        this.event=event;
        this.mtbStstusCode=mtbStstusCode;
        this.errorMsg=errorMsg;
        this.show = show;
        this.span=span;
    }
    /**
     *events for Success login response
     * @param event
     * @param mtbStstusCode
     * @param errorMsg
     *
     */

    public LoginEvent(int event, int mtbStstusCode,String errorMsg,boolean remeberUser,String rsaJsonString){
        this.event=event;
        this.mtbStstusCode=mtbStstusCode;
        this.errorMsg=errorMsg;
        this.remeberUser=remeberUser;
        this.rsaJsonString=rsaJsonString;
    }

    /**
     * Event for load the browser
     * @param event
     * @param url
     */
    public LoginEvent(int event, String url){
        this.event=event;
        this.url=url;
    }

    public LoginEvent(int typeRemovedUsername, boolean removeRememberUser) {
        this.event = typeRemovedUsername;
        this.removed = removeRememberUser;
    }

}
