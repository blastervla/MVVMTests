package Test2;

import java.util.ArrayList;

import Test2.MVVMCommons.DataModel.DataModel;
import Test2.MVVMCommons.DataModel.DataModelAction;

public class UserManagerDataModel implements DataModel {

    ArrayList<String> userList;

    public UserManagerDataModel() {
        this.userList = new ArrayList<>();
    }

    @Override
    public Object handleQuery(/*DataModelQuery*/Object queryParams) {
        return null;
    }

    @Override
    public boolean handleAction(DataModelAction actionParams) {
        switch (actionParams.getAction()) {
            case DataModelAction.ADD:
                return addUser((String) actionParams.getExtraInfo());

            case DataModelAction.DELETE:
                return deleteUser((String) actionParams.getExtraInfo());

            case DataModelAction.UPDATE:
                return updateUser((String[]) actionParams.getExtraInfo());

            default:
                return false;
        }
    }

    private boolean addUser(String user) {
        if(!userList.contains(user)) {
            userList.add(user);
        }
        return true;
    }

    private boolean updateUser(String[] args) {
        if(userList.contains(args[0])) {
            int index = userList.indexOf(args[0]);
            userList.remove(args[0]);
            userList.add(index, args[1]);
            return true;
        }
        return false;
    }

    private boolean deleteUser(String user) {
        if(userList.contains(user)) {
            userList.remove(user);
        }
        return true;
    }
}
