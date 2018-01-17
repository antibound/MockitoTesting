package mbk_load_external.mtb.com.unittesttesting.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class User implements Serializable {

    @SerializedName("UserKey")
    @Expose
    private UserKey userKey;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("EmailAddress")
    @Expose
    private String emailAddress;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @SerializedName("DisplayName")
    @Expose
    private String displayName;
    @SerializedName("IsPaiUser")
    @Expose
    private Boolean isPaiUser;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("LastSignOnDate")
    @Expose
    private String lastSignOnDate;
    @SerializedName("CompanyName")
    @Expose
    private String companyName;

    @SerializedName("Products")
    @Expose
    private List<String> products;

    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("IsRemediationReq")
    @Expose
    private Boolean isRemediationReq;
    @SerializedName("Occupation")
    @Expose
    private String occupation;
    @SerializedName("Citizenship")
    @Expose
    private String citizenship;
    @SerializedName("CustomerAlienStatus")
    @Expose
    private String customerAlienStatus;
    @SerializedName("UserAddress")
    @Expose
    private UserAddress userAddress;

    /**
     * @return The userKey
     */
    public UserKey getUserKey() {
        return userKey;
    }

    /**
     * @param UserKey The userKey
     */
    public void setUserKey(UserKey UserKey) {
        this.userKey = UserKey;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param FirstName The firstName
     */
    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    /**
     * @return The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param LastName The lastName
     */
    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    /**
     * @return The emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param EmailAddress The emailAddress
     */
    public void setEmailAddress(String EmailAddress) {
        this.emailAddress = EmailAddress;
    }

    /**
     * @return The isPaiUser
     */
    public Boolean getIsPaiUser() {
        return isPaiUser;
    }

    /**
     * @param IsPaiUser The isPaiUser
     */
    public void setIsPaiUser(Boolean IsPaiUser) {
        this.isPaiUser = IsPaiUser;
    }

    /**
     * @return The customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param CustomerName The customerName
     */
    public void setCustomerName(String CustomerName) {
        this.customerName = CustomerName;
    }

    /**
     * @return The lastSignOnDate
     */
    public String getLastSignOnDate() {
        return lastSignOnDate;
    }

    /**
     * @param LastSignOnDate The lastSignOnDate
     */
    public void setLastSignOnDate(String LastSignOnDate) {
        this.lastSignOnDate = LastSignOnDate;
    }

    /**
     * @return The companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param CompanyName The companyName
     */
    public void setCompanyName(String CompanyName) {
        this.companyName = CompanyName;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getIsRemediationReq() {
        return isRemediationReq;
    }

    public void setIsRemediationReq(Boolean isRemediationReq) {
        this.isRemediationReq = isRemediationReq;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCustomerAlienStatus() {
        return customerAlienStatus;
    }

    public void setCustomerAlienStatus(String customerAlienStatus) {
        this.customerAlienStatus = customerAlienStatus;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

}
