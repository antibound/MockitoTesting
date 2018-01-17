package mbk_load_external.mtb.com.unittesttesting;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by kenleiphart on 1/16/18.
 */

/**
 * Use this class to invoke service call.
 */
@SuppressWarnings("deprecation")
public class APIServiceTask implements IAPIService {
    private final EventBus mEventBus;
    private boolean isRSARequest=false;

    private ServiceRequest serviceRequest;

    private int originatorEvent = 0;

    public APIServiceTask(){
        this.serviceRequest = new ServiceRequest();
        mEventBus = EventBus.getDefault();
    }

    public APIServiceTask(ServiceRequest request) {
        this.serviceRequest = request;
        mEventBus = EventBus.getDefault();
    }

    public void setContextEvent(int eventType) {
        this.originatorEvent = eventType;
    }

    /*
    This method is used when a service call is expecting RSA Response.
     */
    public void setContextEvent(int eventType,boolean isRSARequest) {
        this.originatorEvent = eventType;
        this.isRSARequest=isRSARequest;
    }

    @SuppressWarnings("ConstantConditions")
    public void execute() {

    }

    @Override
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    @Override
    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }
}
