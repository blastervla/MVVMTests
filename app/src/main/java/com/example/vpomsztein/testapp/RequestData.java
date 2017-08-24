package com.example.vpomsztein.testapp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RequestData {
    private HashMap<String, Data> data;

    public RequestData(HashMap<String, Data> data) {
        this.data = data;
    }

    public Set<Map.Entry<String,Data>> getEntries() {
        return data.entrySet();
    }

    public Collection<Data> getAllData() {
        return data.values();
    }

    public Data getEntry(String key) {
        return data.get(key);
    }

    public void setData(HashMap<String, Data> data) {
        this.data = data;
    }

    public void addEntry(String key, Data data) {
        this.data.put(key, data);
    }

    public void removeEntry(String key) {
        this.data.remove(key);
    }
}

