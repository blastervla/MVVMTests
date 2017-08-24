package Test2.MVVMCommons.DataTransport;

import Test2.MVVMCommons.UIModel;

public class UIEventArgs {
    private String senderID;
    private UIModel extraData;

    public UIEventArgs(String senderID, UIModel extraData) {
        this.senderID = senderID;
        this.extraData = extraData;
    }

    public String getSenderID() {
        return senderID;
    }

    public UIModel getExtraData() {
        return extraData;
    }
}
