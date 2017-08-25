package Test2.MVVMCommons;

import android.support.v7.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

public class MvvmActivity extends AppCompatActivity implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        // no-op
    }
}
