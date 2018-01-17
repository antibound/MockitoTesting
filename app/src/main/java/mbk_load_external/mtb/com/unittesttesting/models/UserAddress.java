package mbk_load_external.mtb.com.unittesttesting.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kenleiphart on 1/16/18.
 */

public class UserAddress implements Serializable {

    @SerializedName("Address1")
    @Expose
    private String address1;
    @SerializedName("Address2")
    @Expose
    private Object address2;
    @SerializedName("Address3")
    @Expose
    private Object address3;
    @SerializedName("Address4")
    @Expose
    private Object address4;
    @SerializedName("Address5")
    @Expose
    private Object address5;
    @SerializedName("FullAddress")
    @Expose
    private String fullAddress;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("State")
    @Expose
    private String state;
    @SerializedName("Country")
    @Expose
    private Object country;
    @SerializedName("ZipCode")
    @Expose
    private String zipCode;
    @SerializedName("ForeignCountry")
    @Expose
    private Object foreignCountry;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public Object getAddress2() {
        return address2;
    }

    public void setAddress2(Object address2) {
        this.address2 = address2;
    }

    public Object getAddress3() {
        return address3;
    }

    public void setAddress3(Object address3) {
        this.address3 = address3;
    }

    public Object getAddress4() {
        return address4;
    }

    public void setAddress4(Object address4) {
        this.address4 = address4;
    }

    public Object getAddress5() {
        return address5;
    }

    public void setAddress5(Object address5) {
        this.address5 = address5;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Object getForeignCountry() {
        return foreignCountry;
    }

    public void setForeignCountry(Object foreignCountry) {
        this.foreignCountry = foreignCountry;
    }

}
