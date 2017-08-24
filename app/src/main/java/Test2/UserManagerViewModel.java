package Test2;

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
        if (e.getData().getSenderID() == "btn_add_user") {

            UserManagerUIModel eventUIModel = (UserManagerUIModel) e.getData().getExtraData();

            //Communicate with dataModel...
            boolean dataModelOperationSuccess = this.dataModel.handleAction(new DataModelAction(DataModelAction.ADD, eventUIModel.getUserNameEditTextValue()));

            //Show toast:
            this.uiModel = eventUIModel;

            String toastMessage = dataModelOperationSuccess ? "Added user " + eventUIModel.getUserNameEditTextValue() : "Could not add user " + eventUIModel.getUserNameEditTextValue();
            eventUIModel.setToastContent(toastMessage);
            this.uiModel = UserManagerUIModel.modelFromModel(eventUIModel);
            activity.updateUIModel(eventUIModel);

        } else if (e.getData().getSenderID() == "btn_delete_user") {

            UserManagerUIModel eventUIModel = (UserManagerUIModel) e.getData().getExtraData();

            //Communicate with dataModel...
            boolean dataModelOperationSuccess = this.dataModel.handleAction(new DataModelAction(DataModelAction.DELETE, eventUIModel.getUserNameEditTextValue()));

            //Show toast:
            this.uiModel = eventUIModel;

            String toastMessage = dataModelOperationSuccess ? "Deleted user " + eventUIModel.getUserNameEditTextValue() : "Could not delete user " + eventUIModel.getUserNameEditTextValue();
            eventUIModel.setToastContent(toastMessage);
            this.uiModel = UserManagerUIModel.modelFromModel(eventUIModel);
            activity.updateUIModel(eventUIModel);
        }
    }
}
