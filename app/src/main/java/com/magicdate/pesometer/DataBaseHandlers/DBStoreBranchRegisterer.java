package com.magicdate.pesometer.DataBaseHandlers;

import com.magicdate.pesometer.DataBaseObjects.ShoppingPathDataBase;
import com.magicdate.pesometer.DataBaseObjects.StroreBranchDataBase;
import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.NavigationElements.PathTracker;
import com.magicdate.pesometer.NavigationElements.Point;

public class DBStoreBranchRegisterer extends FireBaseModel implements DataBaseSubject {

    String branchOfShopping = "Ron's All Goods Store";

    public void handleBranchStock(PathTracker tracker){handleStock(tracker);}

    private void handleStock(PathTracker tracker)
    {
        StroreBranchDataBase stroreBranchDataBase = new StroreBranchDataBase();
        stroreBranchDataBase.setName(branchOfShopping);
        stroreBranchDataBase.setPathTracker(tracker);

        PathNode node = tracker.getList().head;

        String string_dest="";

        while (node != tracker.getList().tail)
        {
            string_dest = node.getDestination();
            Point dest_location = node.getPath().getPoints().get(node.getPath().getPoints().size() - 1);
            stroreBranchDataBase.getProductsOfBranch().put(string_dest ,dest_location);
            node = node.next;
        }
        string_dest = node.getDestination();
        Point dest_location = node.getPath().getPoints().get(node.getPath().getPoints().size() - 1);
        stroreBranchDataBase.getProductsOfBranch().put(string_dest ,dest_location);
        stroreBranchDataBase.getProductsOfBranch().put(string_dest ,dest_location);
        databaseReference.child("SuperMarket Chains").child("Ron's Business Group").child(branchOfShopping)
                .updateChildren(stroreBranchDataBase.getProductsOfBranch());

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
