package com.magicdate.pesometer.DataBaseHandlers;

import com.google.firebase.database.DatabaseReference;
import com.magicdate.pesometer.DataBaseObjects.ShoppingPathDataBase;
import com.magicdate.pesometer.NavigationElements.PathNode;

import java.util.List;

public class DBShoppingPathAppender extends FireBaseModel implements DataBaseSubject {

    public void addAllNodesOfShoppingListToDb(List<PathNode> srcDst)
    {
        writeAllCooardinates(srcDst);
    }

    private void writeAllCooardinates(List<PathNode> srcDst) {
        ShoppingPathDataBase pathDataBase = new ShoppingPathDataBase();
        pathDataBase.setProduct_names(srcDst);
        String timeOfStart = pathDataBase.getStartTime();
        databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history")
         .setValue(timeOfStart);
        for (PathNode pair : srcDst)
        {
            String fromTo = "starting at : " +pair.getSource()+ ", going to : " +pair.getDestination();
            databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(timeOfStart)
            .setValue(fromTo) ;
            for (int i = 0; i < pair.getPath().size() ; i++) {
                String string_i = pair.getPath().getPoints().get(i).toString();
                databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(timeOfStart)
                .child(fromTo).setValue(string_i);
            }
        }
    }

    /**
     *
     * @return a Shopping list from the user's history. still incomplete since i haven't decided yet what is the input? is it date? or to show all options?
     * anyway, it's irrelevant at this phase.
     */
    public DatabaseReference getShoppingListFromDB(){
        return databaseReference;

    }

    @Override
    public void register(DataBaseObserver observer) {

    }

    @Override
    public void unregister(DataBaseObserver observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
