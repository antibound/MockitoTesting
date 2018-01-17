package mbk_load_external.mtb.com.unittesttesting;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mbk_load_external.mtb.com.unittesttesting.events.LoginEvent;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

/**
 * Created by kenleiphart on 12/16/17.
 */

public class BusinessLogicTests {
    @Mock
    ServiceRequest serviceRequest;
    @Mock
    APIServiceTask service;

    private LoginEvent loginEvent;
    private LoginBusinessLogic loginBusinessLogic;
    private String rsa;
    private JSONObject a;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        a = null;
        rsa = "{\n" +
                "\"TIMESTAMP\": \"2017-12-17T17:11:19Z\",\n" +
                "\"HardwareID\": \"-1\",\n" +
                "\"SIM_ID\": \"-1\",\n" +
                "\"PhoneNumber\": \"-1\",\n" +
                "\"GeoLocationInfo\": [\n" +
                "{\n" +
                "\"Timestamp\": \"0\",\n" +
                "\"Status\": \"1\"\n" +
                "}\n" +
                "],\n" +
                "\"DeviceModel\": \"Android SDK built for x86\",\n" +
                "\"MultitaskingSupported\": true,\n" +
                "\"DeviceName\": \"generic_x86\",\n" +
                "\"DeviceSystemName\": \"Android\",\n" +
                "\"DeviceSystemVersion\": \"26\",\n" +
                "\"Languages\": \"en\",\n" +
                "\"WiFiMacAddress\": \"02:00:00:00:00:00\",\n" +
                "\"WiFiNetworksData\": {\n" +
                "\"SignalStrength\": \"-127\",\n" +
                "\"Channel\": \"null\"\n" +
                "},\n" +
                "\"CellTowerId\": \"-1\",\n" +
                "\"LocationAreaCode\": \"-1\",\n" +
                "\"ScreenSize\": \"1080x1794\",\n" +
                "\"RSA_ApplicationKey\": \"4EB86EBA7EFE206853414AD4561C2F79\",\n" +
                "\"MCC\": \"310\",\n" +
                "\"MNC\": \"260\",\n" +
                "\"OS_ID\": \"5cabcf0c606809f8\",\n" +
                "\"SDK_VERSION\": \"3.6.0\",\n" +
                "\"Compromised\": 0,\n" +
                "\"Emulator\": 4\n" +
                "}";
        loginBusinessLogic = LoginBusinessLogic.getInstance(service);

        try {
            a = new JSONObject("{\"DeviceName\":\"generic_x86\",\"IPAddress\":\"10.0.2.15\",\"Manufacturer\":\"Google\",\"Model\":\"Android SDK built for x86\",\"OSVersion\":26,\"AppVersion\":\"1.0\",\"Carrier\":\"Android\",\"ScreenResolution\":\"1080x1794\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().register(this);
    }

    @After
    public void tearDown(){
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(LoginEvent event){
        loginEvent = event;
    }

    @Test
    public void loginSuccessful(){
        doAnswer(JSONResponses.loginSuccessfulJSON())
                .when(service).execute();

        when(service.getServiceRequest()).thenReturn(serviceRequest);
        loginBusinessLogic.setContextEvent(LoginEvent.TYPE_LOGIN);
        loginBusinessLogic.doLogin("test1", "passcode123", true, rsa, a);

//        verify(service).getServiceRequest().setParams(jsonObject.toString());

        EventBus.getDefault().unregister(this);
        Assert.assertNotNull(loginEvent);
        Assert.assertNotNull(loginEvent.userModel);
        Assert.assertEquals(0, loginEvent.event);
        Assert.assertNull(loginEvent.errorMsg);
        Assert.assertEquals("sgrandits@mtb.com", loginEvent.userModel.getEmailAddress());
        Assert.assertEquals("R", loginEvent.userModel.getUserKey().getUserType());
        Assert.assertEquals("Eileen  DICKENSHEETS", loginEvent.userModel.getCustomerName());
    }

    @Test
    public void badUsernamePasscode(){
        service.setServiceRequest(serviceRequest);
        doAnswer(JSONResponses.loginInvalidUsernamePasscodeJSON())
                .when(service).execute();

        when(service.getServiceRequest()).thenReturn(serviceRequest);
        loginBusinessLogic.setContextEvent(LoginEvent.TYPE_LOGIN);
        loginBusinessLogic.doLogin("test1", "passcode123", true, rsa, a);

        Assert.assertNotNull(loginEvent);
        Assert.assertNull(loginEvent.userModel);
        Assert.assertEquals(1, loginEvent.event);
        Assert.assertEquals(40108, loginEvent.mtbStstusCode);
        Assert.assertEquals("User ID or Passcode doesn’t match. Try again.", loginEvent.errorMsg);
    }

    @Test
    public void accountBlocked(){
        service.setServiceRequest(serviceRequest);
        //TODO This code shows we need to pull out the logging methods in the login business logic since we can not test that those methods actually ran.
        doAnswer(JSONResponses.loginAccountBlockedJSON())
                .when(service).execute();

        when(service.getServiceRequest()).thenReturn(serviceRequest);
        loginBusinessLogic.setContextEvent(LoginEvent.TYPE_LOGIN);
        loginBusinessLogic.doLogin("test1", "passcode12", true, rsa, a);

        Assert.assertNotNull(loginEvent);
        Assert.assertNull(loginEvent.userModel);
        Assert.assertEquals(1, loginEvent.event);
        Assert.assertEquals(40104, loginEvent.mtbStstusCode);
        Assert.assertEquals("Your account is locked due to too many failed login attempts. <br><br><a href=https://onlinebanking.mtb.com/login/passcodereset>Reset Passcode ></a>", loginEvent.errorMsg);
    }

    @Test
    public void temporaryPasscode(){
        service.setServiceRequest(serviceRequest);
        //TODO This code shows we need to pull out the logging methods in the login business logic since we can not test that those methods actually ran.
        doAnswer(JSONResponses.loginTemporaryPasscodeJSON())
                .when(service).execute();

        when(service.getServiceRequest()).thenReturn(serviceRequest);
        loginBusinessLogic.setContextEvent(LoginEvent.TYPE_LOGIN);
        loginBusinessLogic.doLogin("test1", "passcode23", true, rsa, a);

        Assert.assertNotNull(loginEvent);
        Assert.assertNull(loginEvent.userModel);
        Assert.assertEquals(1, loginEvent.event);
        Assert.assertEquals(40107, loginEvent.mtbStstusCode);
        Assert.assertEquals("You have logged in with a temporary passcode. Log in to <a href=http://mtb.com/olb-login>M&T Online Banking</a> to create a new passcode.", loginEvent.errorMsg);
    }

    @Test
    public void changedPasscode(){
        service.setServiceRequest(serviceRequest);
        //TODO This code shows we need to pull out the logging methods in the login business logic since we can not test that those methods actually ran.
        doAnswer(JSONResponses.loginFailureChangePasscodeJSON())
                .when(service).execute();

        when(service.getServiceRequest()).thenReturn(serviceRequest);
        loginBusinessLogic.setContextEvent(LoginEvent.TYPE_LOGIN);
        loginBusinessLogic.doLogin("test1", "passcode13", true, rsa, a);

        Assert.assertNotNull(loginEvent);
        Assert.assertNull(loginEvent.userModel);
        Assert.assertEquals(1, loginEvent.event);
        Assert.assertEquals(40107, loginEvent.mtbStstusCode);
        Assert.assertEquals("Your passcode has changed since last login.", loginEvent.errorMsg);
    }
}
