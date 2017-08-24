package Test2.MVVMCommons.DataModel;

public interface DataModel {
    public Object handleQuery(Object queryParams); //TODO: Degeneralize queryParams object type.
    public boolean handleAction(DataModelAction actionParams);
}
