package com.example.vpomsztein.testapp;

import com.example.vpomsztein.testapp.Events.Event;

import java.util.HashMap;

public class ViewModel {
    HashMap<String, HashMap<String, SubscriptionAction>> subscriptions;

    public boolean subscribe(String eventKey, String subscriber, SubscriptionAction action) {
        if (!subscriptions.containsKey(eventKey)) {
            HashMap<String, SubscriptionAction> map = new HashMap<>();
            map.put(subscriber, action);
            subscriptions.put(eventKey, map);
            return true;
        }

        HashMap<String, SubscriptionAction> map = subscriptions.get(eventKey);

        if (!map.containsKey(subscriber)) {
            map.put(subscriber, action);
            return true;
        }

        return false;
    }

    public void unsubscribe(String eventKey, String subscriber) {
        if (subscriptions.containsKey(eventKey)) {
            HashMap<String, SubscriptionAction> map = subscriptions.get(eventKey);
            map.remove(subscriber);
        }
    }

    // Aclarar que no hay que usar 'return super()' salvo que se quiera devolver siempre false.
    public boolean catchEvent(Event e) {
        return false;
    }

    protected void checkSubscriptionsForEvent(Event event) {
        if(subscriptions.containsKey(event.getType())) {
            HashMap<String, SubscriptionAction> subscribers = subscriptions.get(event.getType());

            for(SubscriptionAction actionToExecute : subscribers.values()) {
                actionToExecute.run(event.getEventData());
            }
        }
    }
}
