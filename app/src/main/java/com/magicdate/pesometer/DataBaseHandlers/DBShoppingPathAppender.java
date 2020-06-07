package com.magicdate.pesometer.DataBaseHandlers;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.magicdate.pesometer.DataBaseObjects.ShoppingPathDataBase;
import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.NavigationElements.PathTracker;

import java.util.Map;

public class DBShoppingPathAppender extends FireBaseModel implements DataBaseSubject {


    String date_documentation = "";



    public void addAllNodesOfShoppingListToDb(PathTracker srcDst)
    {
        writeAllCooardinates(srcDst);
    }

    private void writeAllCooardinates(PathTracker tracker) {    // original implementation was for the input (List<PathNode> srcDst) only!
        ShoppingPathDataBase pathDataBase = new ShoppingPathDataBase();
        pathDataBase.setPathTracker(tracker);
        String timeOfStart =  pathDataBase.getStartTime(); // todo : add place "Ron's Stroe"
        date_documentation = timeOfStart;
        PathNode node = tracker.getList().head;
        String string_src="";
        String string_dest="";
        String fromTo="";
        String temp = "";
        int counter = 0;
        while (node != tracker.getList().tail)
        {
            temp = timeOfStart;
            string_src = node.getSource();
            string_dest = node.getDestination();
            fromTo = "starting at : " +string_src+ ", going to : " +string_dest;
            temp = ++counter +" , "+ fromTo;
            pathDataBase.getFrom_tos().put(temp ,node.getPath().getPoints().toString());
            node = node.next;
        }
        fromTo = " " +node.getSource()+ ", going to : " +node.getDestination();
        temp = ++counter +" , "+ fromTo;
        pathDataBase.getFrom_tos().put(temp ,fromTo);
        databaseReference.child("Users").child("This line should be = <user name> ").child("<user name>'s shopping history").child(timeOfStart)
        .updateChildren(pathDataBase.getFrom_tos());
    }

    /**
     *
     * @return a Shopping list from the user's history. still incomplete since i haven't decided yet what is the input? is it date? or to show all options?
     * anyway, it's irrelevant at this phase.
     */

    public void singlePathFromTo(DatabaseReference databaseReference){}

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
