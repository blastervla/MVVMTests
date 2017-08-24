package com.example.vpomsztein.testapp;

import com.example.vpomsztein.testapp.Events.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class ViewModel2 {
    private HashMap<String, ArrayList<Object>> subscriptions;


    public void subscribe(String event, Object subscriber) {
        ArrayList<Object> subscribers;

        if (!subscriptions.containsKey(event)) {
            subscribers = new ArrayList<>();
            subscribers.add(subscriber);
            subscriptions.put(event, subscribers);
        } else {
            subscribers = subscriptions.get(event);
            if (!subscribers.contains(subscriber))
                subscribers.add(subscriber);
            subscriptions.put(event, subscribers);
        }
    }

    public void unsubscribe(String event, Object subscriber) {
        if (subscriptions.containsKey(event)) {
            ArrayList<Object> subscribers = subscriptions.get(event);
            subscribers.remove(subscriber);
        }
    }

    public void unsubscribeFromAllEvents(Object subscriber) {
        Set<String> keySet = subscriptions.keySet();
        ArrayList<Object>[] valueSet = (ArrayList<Object>[]) subscriptions.values().toArray();

        for (String key : keySet) {
            ArrayList<Object> eventSubscriptions = subscriptions.get(key);
            while(eventSubscriptions.contains(subscriber)) {
                eventSubscriptions.remove(subscriber);
            }
            subscriptions.put(key, eventSubscriptions);
        }
    }

    public boolean catchEvent(Event e) {
        return false;
    }
}
