package Test2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserManagerActivity extends MvvmActivity {
    private UserManagerUIModel model;
    private UserManagerViewModel viewModel;

    private EditText txtUsername;
    private Button btnAddUser, btnDeleteUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (EditText) findViewById(R.id.txt_username);

        btnAddUser = (Button) findViewById(R.id.btn_add_user);
        btnDeleteUser = (Button) findViewById(R.id.btn_delete_user);

        model = new UserManagerUIModel();
        viewModel = new UserManagerViewModel(this, UserManagerUIModel.modelFromModel(model));
    }

    public void onAddUserButtonClick(View v) {
        model.setUserNameEditTextValue(txtUsername.getText().toString());
        viewModel.catchEvent(new UIEvent(UIEvent.CLICK, new UIEventArgs("btn_add_user", UserManagerUIModel.modelFromModel(model))));
    }

    public void onDeleteUserButtonClick(View v) {
        model.setUserNameEditTextValue(txtUsername.getText().toString());
        viewModel.catchEvent(new UIEvent(UIEvent.CLICK, new UIEventArgs("btn_delete_user", UserManagerUIModel.modelFromModel(model))));
    }

    @Override
    public void updateUIModel(UIModel model) {
        UserManagerUIModel myModel = (UserManagerUIModel) model;
        if(!this.model.getToastContent().equals(myModel.getToastContent())) {
            Toast.makeText(this, myModel.getToastContent(), Toast.LENGTH_SHORT).show();
        }
    }
}