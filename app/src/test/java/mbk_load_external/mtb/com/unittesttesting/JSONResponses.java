package mbk_load_external.mtb.com.unittesttesting;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
        import org.greenrobot.eventbus.EventBus;

import mbk_load_external.mtb.com.unittesttesting.events.LoginEvent;
import mbk_load_external.mtb.com.unittesttesting.events.ServiceResultEvent;
import mbk_load_external.mtb.com.unittesttesting.models.User;

/**
 * Created by kenleiphart on 7/21/17.
 */

public class JSONResponses {
    public static Answer loginSuccessfulJSON(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String result = "{\n" +
                        "  \"UserKey\": {\n" +
                        "    \"SessionId\": \"01b11ee68cfd8ed730febe2cc3923dc8\",\n" +
                        "    \"UserId\": \"test1r\",\n" +
                        "    \"UserType\": \"R\",\n" +
                        "    \"AuthInternalId\": \"031ES3\",\n" +
                        "    \"MTBToken\": \"d4e67e4d-ae3a-42a2-93b3-3f9de05d51d7\",\n" +
                        "    \"LTToken\": null,\n" +
                        "    \"UserAgentId\": 2587476,\n" +
                        "    \"IsSubUser\": false,\n" +
                        "    \"IsPaiUser\": false,\n" +
                        "    \"HasSubUsers\": false,\n" +
                        "    \"WebRelationshipId\": \"7911000027506123\"\n" +
                        "  },\n" +
                        "  \"EnrolledDate\": \"07/08/2016 00:00:00\",\n" +
                        "  \"PasscodeChangedDate\": \"06/21/2017 03:12:09\",\n" +
                        "  \"DisplayName\": \"EILEEN\",\n" +
                        "  \"FirstName\": \"EILEEN\",\n" +
                        "  \"LastName\": \"DICKENSHEETS\",\n" +
                        "  \"TieBreaker\": \"1\",\n" +
                        "  \"UserRole\": \"PrimaryUser\",\n" +
                        "  \"EmailAddress\": \"sgrandits@mtb.com\",\n" +
                        "  \"Roles\": [\n" +
                        "    \"R\",\n" +
                        "    \"StopPayment\",\n" +
                        "    \"ViewChecks\",\n" +
                        "    \"ViewStatements\",\n" +
                        "    \"EStatementNoticesEligible\",\n" +
                        "    \"EStatementDelivery\",\n" +
                        "    \"BillPay\",\n" +
                        "    \"Transfers\"\n" +
                        "  ],\n" +
                        "  \"UserAddress\": {\n" +
                        "    \"Address1\": \"85 CARSON AVE\",\n" +
                        "    \"Address2\": null,\n" +
                        "    \"Address3\": null,\n" +
                        "    \"Address4\": null,\n" +
                        "    \"Address5\": null,\n" +
                        "    \"FullAddress\": \"85 CARSON AVE\",\n" +
                        "    \"City\": \"HANOVER\",\n" +
                        "    \"State\": \"PA\",\n" +
                        "    \"Country\": null,\n" +
                        "    \"ZipCode\": \"173314109\",\n" +
                        "    \"ForeignCountry\": null\n" +
                        "  },\n" +
                        "  \"CustomerName\": \"Eileen  DICKENSHEETS\",\n" +
                        "  \"WBBId\": null,\n" +
                        "  \"WbkId\": \"7911000027506123\",\n" +
                        "  \"ServiceChargeDetail\": {\n" +
                        "    \"FwPriceCode\": \"NA\",\n" +
                        "    \"FwServiceCharge\": null,\n" +
                        "    \"DcPriceCode\": \"DC2\",\n" +
                        "    \"DcServiceCharge\": null\n" +
                        "  },\n" +
                        "  \"SignOnCount\": 15315,\n" +
                        "  \"PromoCode\": null,\n" +
                        "  \"LastSignOnDate\": \"06/26/2017 11:34:34\",\n" +
                        "  \"CompanyName\": null,\n" +
                        "  \"Products\": [\n" +
                        "    \"DDA\",\n" +
                        "    \"RVL\",\n" +
                        "    \"REA\",\n" +
                        "    \"MTG\"\n" +
                        "  ],\n" +
                        "  \"PasscodeChangeFrequency\": \"365\",\n" +
                        "  \"BusinessEnrollmentType\": \"NONCARD\",\n" +
                        "  \"IsOboUserFirstLogin\": false\n" +
                        "}";
                EventBus.getDefault().post(new ServiceResultEvent(ServiceResultEvent.EVENT_TYPE.success, result, 0));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginFailureChangePasscodeJSON(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String result = "{\"MTBStatusCode\":40107, \"UserMessage\":\"Your passcode has changed since last login.\"}";
                EventBus.getDefault().post(new ServiceResultEvent(ServiceResultEvent.EVENT_TYPE.failed, result, 0));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginAccountBlockedJSON(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String result = "{\"Version\":1,\"MTBStatusCode\":40104,\"HttpStatus\":401,\"UserMessage\":\"\\\"Your account is locked due to too many failed login attempts. <br><br><a href=\\\"https://onlinebanking.mtb.com/login/passcodereset\\\">Reset Passcode ></a>\\\"\",\"DeveloperMessage\":\"\\\"Account locked via multi-factor authentication.\\\"\"}";

                EventBus.getDefault().post(new ServiceResultEvent(ServiceResultEvent.EVENT_TYPE.failed, result, 0));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginAccountBlockedEventPost(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                EventBus.getDefault().postSticky(new LoginEvent(LoginEvent.TYPE_FAILED, 40104, "Your account is locked due to too many failed login attempts. <br><br><a href=https://onlinebanking.mtb.com/login/passcodereset>Reset Passcode ></a>", false, true));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginInvalidUsernamePasscodeJSON(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String result = "{\"Version\":1,\"MTBStatusCode\":40108,\"HttpStatus\":401,\"UserMessage\":\"\\\"User ID or Passcode doesn’t match. Try again.\\\"\",\"DeveloperMessage\":\"\\\"Voyager Error -1073739414 : User ID or Passcode doesn’t match. Try again.\\\"\"}";

                EventBus.getDefault().post(new ServiceResultEvent(ServiceResultEvent.EVENT_TYPE.failed, result, 0));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginTemporaryPasscodeJSON(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                String result = "{\"Version\":1,\"MTBStatusCode\":40107,\"HttpStatus\":401,\"UserMessage\":\"\\\"You have logged in with a temporary passcode. Log in to <a href=\\\"http://mtb.com/olb-login\\\">M&T Online Banking</a> to create a new passcode.\\\"\",\"DeveloperMessage\":\"\\\"Password should be changed.\\\"\"}";

                EventBus.getDefault().post(new ServiceResultEvent(ServiceResultEvent.EVENT_TYPE.failed, result, 0));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginInvalidUsernamePasscodeEventPost(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                EventBus.getDefault().post(new LoginEvent(LoginEvent.TYPE_FAILED, 40108, "User ID or Passcode doesn’t match. Try again.", false, true));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginTemporaryPasscodeEventPost(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                EventBus.getDefault().post(new LoginEvent(LoginEvent.TYPE_FAILED, 40107, "You have logged in with a temporary passcode. Log in to <a href=\\\"http://mtb.com/olb-login\\\">M&T Online Banking</a> to create a new passcode.", false, true));
                return null;
            }
        };

        return answer;
    }

    public static Answer loginSuccessfulEventPost(){
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                EventBus.getDefault().post(new LoginEvent(LoginEvent.TYPE_SUCCESS, new User()));
                return null;
            }
        };

        return answer;
    }

}
