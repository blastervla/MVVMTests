package com.example.vpomsztein.testapp;

import java.util.ArrayList;

public class UserModel {
    private ArrayList<String> users = new ArrayList<>();

    public UserModel() {}

    public ArrayList<String> getUsers() {
        return users;
    }

    public void addUser(String user) {
        users.add(user);
    }

    public void removeUser(String user) {
        users.remove(user);
    }
}
