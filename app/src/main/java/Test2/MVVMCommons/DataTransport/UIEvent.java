package Test2.MVVMCommons.DataTransport;

public class UIEvent extends Event {
    public static final String CLICK = "Click";
    public static final String EDIT_TEXT_INPUT = "EditTextInput";

    public UIEvent(String eventType, String sender) {
        super();
        this.eventType = eventType;
        this.eventData = (Object) sender;
    }

    /**
     * Returns the event's sender ID.
     * @return Event's sender ID.
     */
    @Override
    public String getData() {
        return (String) super.getData();
    }
}