package Test2.MVVMCommons.DataTransport;

import Test2.MVVMCommons.MvvmActivity;

public class UIEventArgs {
    private String senderID;

    public UIEventArgs(String senderID) {
        this.senderID = senderID;
    }

    public String getSenderID() {
        return senderID;
    }
}
