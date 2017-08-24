package Test2;

import Test2.MVVMCommons.UIModel;

public class UserManagerUIModel implements UIModel {

    private String userNameEditTextValue;
    private String toastContent;

    public UserManagerUIModel() {
        this.userNameEditTextValue = "";
        this.toastContent = "";
    }

    public String getUserNameEditTextValue() {
        return userNameEditTextValue;
    }

    public void setUserNameEditTextValue(String userNameEditTextValue) {
        this.userNameEditTextValue = userNameEditTextValue;
    }

    public String getToastContent() {
        return toastContent;
    }

    public void setToastContent(String toastContent) {
        this.toastContent = toastContent;
    }

    public static UserManagerUIModel modelFromModel(UserManagerUIModel model) {
        UserManagerUIModel toReturn = new UserManagerUIModel();
        toReturn.setToastContent(model.getToastContent());
        toReturn.setUserNameEditTextValue(model.getUserNameEditTextValue());
        return toReturn;
    }
}