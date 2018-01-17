package mbk_load_external.mtb.com.unittesttesting.models;

/**
 * Created by kenleiphart on 1/16/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("ALL")
public class ErrorModel {

    @SerializedName("Version")
    @Expose
    private Integer Version;
    @SerializedName("MTBStatusCode")
    @Expose
    private Integer MTBStatusCode;
    @SerializedName("HttpStatus")
    @Expose
    private Integer HttpStatus;
    @SerializedName("UserMessage")
    @Expose
    private String UserMessage;
    @SerializedName("DeveloperMessage")
    @Expose
    private String DeveloperMessage;

    /**
     *
     * @return
     * The Version
     */
    public Integer getVersion() {
        return Version;
    }

    /**
     *
     * @param Version
     * The Version
     */
    public void setVersion(Integer Version) {
        this.Version = Version;
    }

    /**
     *
     * @return
     * The MTBStatusCode
     */
    public Integer getMTBStatusCode() {
        return MTBStatusCode;
    }

    /**
     *
     * @param MTBStatusCode
     * The MTBStatusCode
     */
    public void setMTBStatusCode(Integer MTBStatusCode) {
        this.MTBStatusCode = MTBStatusCode;
    }

    /**
     *
     * @return
     * The HttpStatus
     */
    public Integer getHttpStatus() {
        return HttpStatus;
    }

    /**
     *
     * @param HttpStatus
     * The HttpStatus
     */
    public void setHttpStatus(Integer HttpStatus) {
        this.HttpStatus = HttpStatus;
    }

    /**
     *
     * @return
     * The UserMessage
     */
    public String getUserMessage() {
        return UserMessage;
    }

    /**
     *
     * @param UserMessage
     * The UserMessage
     */
    public void setUserMessage(String UserMessage) {
        this.UserMessage = UserMessage;
    }

    /**
     *
     * @return
     * The DeveloperMessage
     */
    public String getDeveloperMessage() {
        return DeveloperMessage;
    }

    /**
     *
     * @param DeveloperMessage
     * The DeveloperMessage
     */
    public void setDeveloperMessage(String DeveloperMessage) {
        this.DeveloperMessage = DeveloperMessage;
    }
}
