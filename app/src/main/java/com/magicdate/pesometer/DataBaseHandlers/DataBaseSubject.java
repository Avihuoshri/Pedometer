package com.magicdate.pesometer.DataBaseHandlers;

public interface DataBaseSubject {
    /*
       This interface represents any object that require any kind of a dataBase related update
       every instance such as this has a list of observers (see other interface)
       it looks like this:

       private List<DataBaseObserver> observers= new ArrayList<DataBaseObserver>();
     */

    public void register(DataBaseObserver observer);
    public void unregister(DataBaseObserver observer);

    /**
     * notify all observers in list that a change has occurred.
     * for each -> observer.notifyDB()
     */
    public void notifyObservers();
}
