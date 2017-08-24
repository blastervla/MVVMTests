package Test2.MVVMCommons.DataModel;

public class DataModelQuery {
    public static final String VALUE = "VALUE";

    protected String type;
    protected Object extraInfo;

    public DataModelQuery(String type, Object args) {
        this.type = type;
        this.extraInfo = args;
    }

    public String getType() {
        return type;
    }

    public Object getExtraInfo() {
        return extraInfo;
    }
}
