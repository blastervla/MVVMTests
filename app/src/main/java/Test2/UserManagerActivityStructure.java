package Test2;

import java.util.Observable;

import Test2.MVVMCommons.ActivityStructure;

public class UserManagerActivityStructure extends Observable{
    private String usernameText;
    private String toastMessage;
    private String alertDialogTitle;
    private String alertDialogContent;

    public UserManagerActivityStructure() {
        this.usernameText = "";
        this.toastMessage = "";
        this.alertDialogTitle = "";
        this.alertDialogContent = "";
    }

    public UserManagerActivityStructure(String usernameText) {
        this.usernameText = usernameText;
    }

    public String getUsernameText() {
        return usernameText;
    }

    public void setUsernameText(String usernameText) {
        this.usernameText = usernameText;
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }

    public String getAlertDialogTitle() {
        return alertDialogTitle;

    }

    public void setAlertDialogTitle(String alertDialogTitle) {
        this.alertDialogTitle = alertDialogTitle;
    }

    public String getAlertDialogContent() {
        return alertDialogContent;
    }

    public void setAlertDialogContent(String alertDialogContent) {
        this.alertDialogContent = alertDialogContent;
    }

    public void notifySubscribers() {
        setChanged();
        notifyObservers();
    }
}
