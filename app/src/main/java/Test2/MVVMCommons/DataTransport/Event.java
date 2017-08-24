package Test2.MVVMCommons.DataTransport;

public class Event {
    protected String eventType;
    protected Object eventData;

    public Event() {}

    public Event(String eventType) {
        this.eventType = eventType;
    }

    public Event(String eventType, Object eventData) {
        this.eventType = eventType;
        this.eventData = eventData;
    }

    public String getType() {
        return eventType;
    }

    public Object getData() {
        return eventData;
    }
}
