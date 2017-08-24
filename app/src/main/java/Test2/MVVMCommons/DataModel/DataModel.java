package Test2.MVVMCommons.DataModel;

public interface DataModel {
    public Object handleQuery(DataModelQuery queryParams);
    public boolean handleAction(DataModelAction actionParams);
}