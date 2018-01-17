package mbk_load_external.mtb.com.unittesttesting.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kenleiphart on 1/16/18.
 */

public class UserKey implements Serializable {
    @SerializedName("SessionId")
    @Expose
    private String sessionId;

    @SerializedName("UserId")
    @Expose
    private String userId;

    @SerializedName("UserType")
    @Expose
    private String userType;

    @SerializedName("IsPaiUser")
    @Expose
    private Boolean isPaiUser;

    @SerializedName("InternalUserId")
    @Expose
    private int InternalUserId;

    @SerializedName("IsSubUser")
    @Expose
    private Boolean IsSubUser;

    @SerializedName("HasSubUsers")
    @Expose
    private Boolean HasSubUsers;

    @SerializedName("MTBToken")
    @Expose
    private String mTBToken;
    @SerializedName("AuthInternalId")
    @Expose
    private String authInternalId;
    @SerializedName("WebRelationshipId")
    @Expose
    private String webRelationshipId;

    /**
     *
     * @return
     * The InternalUserId
     */
    public int getInternalUserId() {
        return InternalUserId;
    }

    /**
     *
     * @param InternalUserId
     * The InternalUserId
     */
    public void setInternalUserId(int InternalUserId) {
        this.InternalUserId = InternalUserId;
    }

    /**
     *
     * @return
     * The IsSubUser
     */
    public Boolean getIsSubUser() {
        return IsSubUser;
    }
    public String getAuthInternalId() {
        return authInternalId;
    }

    public void setAuthInternalId(String authInternalId) {
        this.authInternalId = authInternalId;
    }

    public String getWebRelationshipId() {
        return webRelationshipId;
    }

    public void setWebRelationshipId(String webRelationshipId) {
        this.webRelationshipId = webRelationshipId;
    }

    /**
     *
     * @param IsSubUser
     * The IsSubUser
     */
    public void setIsSubUser(Boolean IsSubUser) {
        this.IsSubUser = IsSubUser;
    }

    public Boolean getIsPaiUser() {
        return isPaiUser;
    }

    public void setIsPaiUser(Boolean isPaiUser) {
        this.isPaiUser = isPaiUser;
    }

    /**
     *
     * @return
     * The SessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     *
     * @param SessionId
     * The SessionId
     */
    public void setSessionId(String SessionId) {
        this.sessionId = SessionId;
    }

    /**
     *
     * @return
     * The UserId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param UserId
     * The UserId
     */
    public void setUserId(String UserId) {
        this.userId = UserId;
    }

    /**
     *
     * @return
     * The UserType
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param UserType - User Type R/B
     * The UserType
     */
    public void setUserType(String UserType) {
        this.userType = UserType;
    }

    public Boolean getHasSubUsers() {
        return HasSubUsers;
    }

    public void setHasSubUsers(Boolean hasSubUsers) {
        HasSubUsers = hasSubUsers;
    }

    public String getmTBToken() {
        return mTBToken;
    }

    public void setmTBToken(String mTBToken) {
        this.mTBToken = mTBToken;
    }
}
