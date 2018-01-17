package mbk_load_external.mtb.com.unittesttesting;

/**
 * Created by kenleiphart on 1/16/18.
 */

class ServiceRequest {
    private String url;
    private String params;
    public RequestType reqType;

    public enum RequestType {
        get, post, put, delete
    }

    public void buildUrl(String methodName) {
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setReqType(RequestType reqType) {
        this.reqType = reqType;
    }
}
