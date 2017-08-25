package Test2;

import java.util.List;

import Test2.MVVMCommons.DataModel.DataModelAction;
import Test2.MVVMCommons.DataModel.DataModelQuery;
import Test2.MVVMCommons.DataTransport.Event;
import Test2.MVVMCommons.DataTransport.UIEvent;
import Test2.MVVMCommons.ViewModel;

public class UserManagerViewModel implements ViewModel {

    private UserManagerDataModel dataModel;
    private UserManagerActivityStructure structure;

    public UserManagerViewModel() {
        this.dataModel = new UserManagerDataModel();
        this.structure = new UserManagerActivityStructure();
    }

    @Override
    public boolean catchEvent(Event e) {
        if (e instanceof UIEvent) {
            switch (e.getType()) {
                case UIEvent.CLICK:
                    handleClickEvent((UIEvent) e);
                    return true;
            }
        }
        return false;
    }

    @Override
    public UserManagerActivityStructure getStructure() {
        return this.structure;
    }

    private void handleClickEvent(UIEvent e) {
        switch (e.getData()) {
            case "btn_add_user":
                //Communicate with dataModel...
                String username = structure.getUsernameText();
                boolean dataModelOperationSuccess = this.dataModel.handleAction(new DataModelAction(DataModelAction.ADD, username));

                //Show toast:
                String toastMessage = dataModelOperationSuccess ? "Added user " + username : "Could not add user " + username;
                structure.setToastMessage(toastMessage);
                structure.notifySubscribers();
                break;

            case "btn_delete_user":
                //Communicate with dataModel...
                username = structure.getUsernameText();
                dataModelOperationSuccess = this.dataModel.handleAction(new DataModelAction(DataModelAction.DELETE, username));

                //Show toast:
                toastMessage = dataModelOperationSuccess ? "Deleted user " + username : "Could not delete user " + username;
                structure.setToastMessage(toastMessage);
                structure.notifySubscribers();
                break;

            case "btn_user_list":

                List<String> userList = (List<String>) dataModel.handleQuery(new DataModelQuery(DataModelQuery.VALUE, UserManagerDataModel.USER_LIST_VALUE));

                String userListString = "";

                for (String user : userList) {
                    userListString += " - " + user + "\n";
                }

                structure.setAlertDialogTitle("Currently registered users:");
                structure.setAlertDialogContent(userListString);
                structure.notifySubscribers();
                break;
        }
    }
}
