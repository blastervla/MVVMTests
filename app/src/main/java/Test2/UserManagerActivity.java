package Test2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Test2.MVVMCommons.KeyValuePair;
import Test2.MVVMCommons.MvvmActivity;
import Test2.MVVMCommons.DataTransport.UIEvent;
import Test2.MVVMCommons.DataTransport.UIEventArgs;
import Test2.MVVMCommons.UIModel;

public class UserManagerActivity extends MvvmActivity {
    private UIModel model;
    private UserManagerViewModel viewModel;

    private EditText txtUsername;
    private Button btnAddUser, btnDeleteUser, btnUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (EditText) findViewById(R.id.txt_username);

        btnAddUser = (Button) findViewById(R.id.btn_add_user);
        btnDeleteUser = (Button) findViewById(R.id.btn_delete_user);
        btnUserList = (Button) findViewById(R.id.btn_user_list);

        model = UserManagerUIModelHolder.getModel();
        viewModel = new UserManagerViewModel(this, model);
    }

    public void onAddUserButtonClick(View v) {
        this.model = model.copy(new KeyValuePair<>("userNameEditTextValue", txtUsername.getText().toString()));
        viewModel.catchEvent(new UIEvent(UIEvent.CLICK, new UIEventArgs("btn_add_user", model)));
    }

    public void onDeleteUserButtonClick(View v) {
        this.model = model.copy(new KeyValuePair<>("userNameEditTextValue", txtUsername.getText().toString()));
        viewModel.catchEvent(new UIEvent(UIEvent.CLICK, new UIEventArgs("btn_delete_user", model)));
    }

    public void onUserListButtonClick(View v) {
        viewModel.catchEvent(new UIEvent(UIEvent.CLICK, new UIEventArgs("btn_user_list", model)));
    }

    @Override
    public void updateUIModel(UIModel model) {
        if (!this.model.get("toastContent").equals(model.get("toastContent"))) {
            Toast.makeText(this, model.get("toastContent"), Toast.LENGTH_SHORT).show();
        }

        if (!this.model.get("userListDialogContent").equals(model.get("userListDialogContent"))) {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setTitle(model.get("userListDialogTitle"));
            dlgAlert.setMessage(model.get("userListDialogContent"));
            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dlgAlert.create().show();
        }
    }
}