package Test2;

import java.util.List;

import Test2.MVVMCommons.DataModel.DataModelAction;
import Test2.MVVMCommons.DataModel.DataModelQuery;
import Test2.MVVMCommons.DataTransport.Event;
import Test2.MVVMCommons.KeyValuePair;
import Test2.MVVMCommons.MvvmActivity;
import Test2.MVVMCommons.DataTransport.UIEvent;
import Test2.MVVMCommons.UIModel;
import Test2.MVVMCommons.ViewModel;

public class UserManagerViewModel extends ViewModel {

    UserManagerDataModel dataModel;

    public UserManagerViewModel(MvvmActivity activity, UIModel uiModel) {
        super(activity, uiModel);
        this.dataModel = new UserManagerDataModel();
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

    private void handleClickEvent(UIEvent e) {
        UIModel eventUIModel = e.getData().getExtraData();
        this.uiModel = eventUIModel;

        switch (e.getData().getSenderID()) {
            case "btn_add_user":
                //Communicate with dataModel...
                String editTextValue = eventUIModel.get("userNameEditTextValue");
                boolean dataModelOperationSuccess = this.dataModel.handleAction(new DataModelAction(DataModelAction.ADD, editTextValue));

                //Show toast:
                String toastMessage = dataModelOperationSuccess ? "Added user " + editTextValue : "Could not add user " + editTextValue;
                this.uiModel = uiModel.copy(new KeyValuePair<>("toastContent", toastMessage));
                activity.updateUIModel(this.uiModel);
                break;

            case "btn_delete_user":
                //Communicate with dataModel...
                editTextValue = eventUIModel.get("userNameEditTextValue");
                dataModelOperationSuccess = this.dataModel.handleAction(new DataModelAction(DataModelAction.DELETE, editTextValue));

                //Show toast:
                toastMessage = dataModelOperationSuccess ? "Deleted user " + editTextValue : "Could not delete user " + editTextValue;
                this.uiModel = uiModel.copy(new KeyValuePair<>("toastContent", toastMessage));
                activity.updateUIModel(this.uiModel);
                break;

            case "btn_user_list":

                List<String> userList = (List<String>) dataModel.handleQuery(new DataModelQuery(DataModelQuery.VALUE, UserManagerDataModel.USER_LIST_VALUE));

                String userListString = "";

                for (String user : userList) {
                    userListString += " - " + user + "\n";
                }

                this.uiModel = uiModel.copy(new KeyValuePair<>("userListDialogTitle", "Currently registered users:"), new KeyValuePair<>("userListDialogContent", userListString));
                activity.updateUIModel(uiModel);
                break;
        }
    }
}
