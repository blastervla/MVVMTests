package com.example.vpomsztein.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vpomsztein.testapp.Events.UIEvent;

import java.util.HashMap;
import java.util.Map;

import Test2.R;

public class MainActivity extends MVVMActivity {

    private final String VIEW_TAG = "MainActivity";

    UserViewModel viewModel;

    EditText txtUsername;
    Button btnAdd, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtUsername = (EditText) findViewById(R.id.txt_username);
        this.btnAdd = (Button) findViewById(R.id.btn_add_user);
        this.btnDelete = (Button) findViewById(R.id.btn_delete_user);

        viewModel = new UserViewModel(this);
    }

    private void onAddUserButtonClick() {
        //viewModel.catchEvent(new UIEvent())
    }
}
