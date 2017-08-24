package com.example.vpomsztein.testapp.Events;

import com.example.vpomsztein.testapp.MVVMActivity;

public class UIEvent extends Event {
    protected MVVMActivity sender;

    public UIEvent(String eventType) {
        super(eventType);
    }

    public MVVMActivity getSender() {
        return sender;
    }

    public void setSender(MVVMActivity sender) {
        this.sender = sender;
    }
}
