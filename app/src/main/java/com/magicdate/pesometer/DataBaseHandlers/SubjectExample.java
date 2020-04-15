package com.magicdate.pesometer.DataBaseHandlers;

import java.util.ArrayList;
import java.util.List;

public class SubjectExample implements DataBaseSubject {
    private List<DataBaseObserver> observers= new ArrayList<DataBaseObserver>();
    @Override
    public void register(DataBaseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(DataBaseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (DataBaseObserver observer : observers)
        {
            observer.notifyDB();
        }
    }
}
