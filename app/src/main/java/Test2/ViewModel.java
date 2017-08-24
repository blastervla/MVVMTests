package Test2;

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