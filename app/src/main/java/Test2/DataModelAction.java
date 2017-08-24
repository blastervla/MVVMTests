package Test2;

public class DataModelAction {
    public static final String ADD = "ADD";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    protected String action;
    protected Object extraInfo;

    public DataModelAction(String action, Object extraInfo) {
        this.action = action;
        this.extraInfo = extraInfo;
    }

    public String getAction() {
        return action;
    }

    public Object getExtraInfo() {
        return extraInfo;
    }
}
