package mbk_load_external.mtb.com.unittesttesting;

/**
 * Created by kenleiphart on 1/16/18.
 */

interface IAPIService {
    void execute();

    ServiceRequest getServiceRequest();

    void setServiceRequest(ServiceRequest serviceRequest);
}
