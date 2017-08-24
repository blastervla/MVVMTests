package Test2.MVVMCommons;

import Test2.MVVMCommons.DataTransport.Event;

public class ViewModel {
    protected MvvmActivity activity;
    protected UIModel uiModel;

    public ViewModel(MvvmActivity activity, UIModel uiModel) {
        this.activity = activity;
        this.uiModel = uiModel;
    }

    public boolean catchEvent(Event e){
        return false;
    }
}