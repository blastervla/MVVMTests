package com.example.vpomsztein.testapp;

import com.example.vpomsztein.testapp.Events.Event;
import com.example.vpomsztein.testapp.Events.UIEvent;

public class UserViewModel extends ViewModel2{
    UserModel userModel;
    private MVVMActivity view;
    private UIModel uiModel;

    public UserViewModel(MVVMActivity mvvmActivity) {
        this.view = mvvmActivity;
        userModel = new UserModel();
    }

    public void addUser(String username) {
        userModel.addUser(username);
    }

    public void removeUser(String username) {
        userModel.removeUser(username);
    }

    @Override
    public boolean catchEvent(Event e) {
        switch (e.getType()) {
            case "TEXT_INPUT":
                /*if(e.getEntry("which") == "main_button") {
                    userModel.addUser(e.payload.inputText);
                }*/
                break;

            case "CHANGE_TEXT_INPUT":

                break;
            default:
                return false;
        }
        return true;
    }
}