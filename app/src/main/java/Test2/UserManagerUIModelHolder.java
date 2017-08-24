package Test2;

import Test2.MVVMCommons.InvalidModelException;
import Test2.MVVMCommons.UIModel;

public class UserManagerUIModelHolder {

    private static String modelData = "<userNameEditTextValue value=''>" +
                                      "<toastContent value=''>" +
                                      "<userListDialogTitle value=''>" +
                                      "<userListDialogContent value=''>";

    public static UIModel getModel() {
        try {
            return new UIModel(modelData);
        } catch (InvalidModelException e) {
            e.printStackTrace();
        }
        return null;
    }
}