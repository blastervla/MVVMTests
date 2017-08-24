package Test2;

import android.support.v7.app.AppCompatActivity;

public class MvvmActivity extends AppCompatActivity {
    protected UIModel model;

    public void updateUIModel(UIModel model) {
        this.model = model;
    }
}
