package Test2.MVVMCommons;

import android.support.v7.app.AppCompatActivity;

public class MvvmActivity extends AppCompatActivity {
    protected UIModel model;

    public void updateUIModel(UIModel model) {
        this.model = model;
    }
}
