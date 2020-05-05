package com.magicdate.pesometer.DataBaseHandlers;

import com.google.firebase.database.DatabaseReference;
import com.magicdate.pesometer.DataBaseObjects.ShoppingPathDataBase;
import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.NavigationElements.PathTracker;

import java.util.Map;

public class DBShoppingPathAppender extends FireBaseModel implements DataBaseSubject {


    public void addAllNodesOfShoppingListToDb(PathTracker srcDst)
    {
        writeAllCooardinates(srcDst);
    }

    private void writeAllCooardinates(PathTracker tracker) {    // original implementation was for the input (List<PathNode> srcDst) only!
        ShoppingPathDataBase pathDataBase = new ShoppingPathDataBase();
        pathDataBase.setPathTracker(tracker);
        String timeOfStart = pathDataBase.getStartTime();
        databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history")
        .setValue(timeOfStart);
        PathNode node = tracker.getList().head;
        String string_src;
        String string_dest;
        String fromTo;
        String key;
        while (node != tracker.getList().tail)
        {
            key = databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(timeOfStart).push().getKey();
            string_src = node.getSource();
            string_dest = node.getDestination();
            fromTo = "starting at : " +string_src+ ", going to : " +string_dest;
            String temp = timeOfStart+key;
            pathDataBase.getFrom_tos().put(temp ,fromTo);
            databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(temp)
            .updateChildren(pathDataBase.getFrom_tos());
            node = node.next;
        }
        node = tracker.getList().head;
        while (node != tracker.getList().tail)
        {
            String current_path = node.getPath().toString();
            for (Map.Entry<String,Object> entry : pathDataBase.getPoints().entrySet())
            {
                pathDataBase.getPoints().put(entry.getKey(),current_path);
                databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history")
                .child(timeOfStart).child(entry.getKey()).updateChildren(pathDataBase.getPoints()); //.setValue(current_path);
                //databaseReference.updateChildren(pathDataBase.getPoints());
            }
            node = node.next;
        }
        string_src = node.getSource();
        string_dest = node.getDestination();
        fromTo = "starting at : " +string_src+ ", going to : " +string_dest;
        //databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(timeOfStart)
        // .setValue(fromTo) ;
        /*
        for (Point point : node.getPath().getPoints())
        {
            String string_ofPoint = point.toString();
            databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(timeOfStart)
            .child(fromTo).setValue(string_ofPoint);
        }

         */
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
