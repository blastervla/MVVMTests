package com.example.vpomsztein.testapp.Events;

import com.example.vpomsztein.testapp.RequestData;
import com.example.vpomsztein.testapp.Data;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Event {
    protected String eventType = "EVENT";
    protected RequestData eventData = null;

    public Event(String eventType) {
        this.eventType = eventType;
    }

    public Set<Map.Entry<String,Data>> getEntries() {
        return eventData.getEntries();
    }

    public Collection<Data> getAllData() {
        return eventData.getAllData();
    }

    public Data getEntry(String key) {
        return eventData.getEntry(key);
    }

    public void setData(RequestData data) {
        this.eventData = data;
    }
    public void addEntry(String key, Data value) {
        this.eventData.addEntry(key, value);
    }
    public void removeEntry(String key) {
        this.eventData.removeEntry(key);
    }

    public String getType() {
        return eventType;
    }

    public void setType(String eventType) {
        this.eventType = eventType;
    }

    public RequestData getEventData() {
        return eventData;
    }

    public void setEventData(RequestData eventData) {
        this.eventData = eventData;
    }
}
