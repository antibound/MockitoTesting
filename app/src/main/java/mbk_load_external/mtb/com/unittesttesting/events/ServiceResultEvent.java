package mbk_load_external.mtb.com.unittesttesting.events;

/**
 * Created by kenleiphart on 1/16/18.
 */

public class ServiceResultEvent {
    public enum EVENT_TYPE {success, failed, cancelled, error}

    public final String result;
    public final EVENT_TYPE event;
    public final int originatorEvent;

    public ServiceResultEvent(EVENT_TYPE event, String result, int originatorEventType)
    {
        this.event = event;
        this.result = result;
        this.originatorEvent = originatorEventType;
    }

}
