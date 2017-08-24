package Test2;

public class UIEvent extends Event {
    public static final String CLICK = "Click";
    public static final String EDIT_TEXT_INPUT = "EditTextInput";

    public UIEvent(String eventType, UIEventArgs eventData) {
        super();
        this.eventType = eventType;
        this.eventData = (Object) eventData;
    }

    @Override
    public UIEventArgs getData() {
        return (UIEventArgs) super.getData();
    }
}