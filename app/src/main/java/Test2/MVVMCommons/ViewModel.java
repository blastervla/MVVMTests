package Test2.MVVMCommons;

import java.util.Observable;

import Test2.MVVMCommons.DataTransport.Event;

public interface ViewModel {
    public boolean catchEvent(Event e);
    public Observable getStructure();
}