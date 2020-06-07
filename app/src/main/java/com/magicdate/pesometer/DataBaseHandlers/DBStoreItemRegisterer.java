package com.magicdate.pesometer.DataBaseHandlers;

import com.google.firebase.database.DatabaseReference;
import com.magicdate.pesometer.DataBaseObjects.StoreItemRegisterer;

public class DBStoreItemRegisterer extends FireBaseModel implements DataBaseSubject {
    /**
     * function registers a new product to db
     * @param itemName is a supermarket actual retail's product name
     * @param i
     * @param j
     */

    public void addStoreItemToDB(String itemName,int i,int j){
        writeNewStoreItem2db(itemName,i,j);
    }

    private void writeNewStoreItem2db(String itemName, int i, int j)
    {
        StoreItemRegisterer storeItemRegisterer = new StoreItemRegisterer();
        storeItemRegisterer.setNameOfProductInStock(itemName);
        storeItemRegisterer.setLocationPoint(i,j);
        databaseReference.child("Products").child(itemName).setValue(storeItemRegisterer);
    }

    /**
     *
     * @param itemName a name of a store item.
     * @return a pointer to the database object.
     */
    public DatabaseReference getStoreItemFromDB(String itemName){
        return databaseReference.child("Products").child(itemName);
    }

    @Override
    public void register(DataBaseObserver observer) {

    }
    @Override
    public void unregister(DataBaseObserver observer) {

    }

    @Override
    public void notifyObservers() {
        String s = " i , am ,appool" ;

    }

}
