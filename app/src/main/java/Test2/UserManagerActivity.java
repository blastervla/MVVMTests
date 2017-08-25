package Test2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Observable;

import Test2.MVVMCommons.MvvmActivity;
import Test2.MVVMCommons.DataTransport.UIEvent;
import Test2.databinding.ActivityMainBinding;

public class UserManagerActivity extends MvvmActivity {
    private UserManagerViewModel viewModel;
    UserManagerActivityStructure structure;

    private EditText txtUsername;
    private Button btnAddUser, btnDeleteUser, btnUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        txtUsername = (EditText) findViewById(R.id.txt_username);

        btnAddUser = (Button) findViewById(R.id.btn_add_user);
        btnDeleteUser = (Button) findViewById(R.id.btn_delete_user);
        btnUserList = (Button) findViewById(R.id.btn_user_list);
        viewModel = new UserManagerViewModel();
        binding.setUserManagerData(viewModel.getStructure());
        viewModel.getStructure().addObserver(this);
    }

    public void onAddUserButtonClick(View v) {
        catchClickEvent("btn_add_user");
    }

    public void onDeleteUserButtonClick(View v) {
        catchClickEvent("btn_delete_user");
    }

    public void onUserListButtonClick(View v) {
        catchClickEvent("btn_user_list");
    }

    private void catchClickEvent(String sender) {
        viewModel.catchEvent(new UIEvent(UIEvent.CLICK, sender));
    }

    @Override
    public void update(Observable o, Object arg) {
        rebuildActivity((UserManagerActivityStructure) o);
    }

    private void rebuildActivity(UserManagerActivityStructure structure) {
        if (!structure.getAlertDialogTitle().equals("") || !structure.getAlertDialogContent().equals("")) {
            showAlertDialog(structure.getAlertDialogTitle(), structure.getAlertDialogContent());
            structure.setAlertDialogTitle("");
            structure.setAlertDialogContent("");
        }

        if (!structure.getToastMessage().equals("")) {
            showToast(structure.getToastMessage());
            structure.setToastMessage("");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog(String title, String content) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setTitle(title);
        dlgAlert.setMessage(content);
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dlgAlert.create().show();
    }
}