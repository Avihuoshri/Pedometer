package com.magicdate.pesometer.navigation;

import com.magicdate.pesometer.interfaces.Navigate;
import com.magicdate.pesometer.interfaces.Record;

public class RouteTracker implements Record, Navigate {


    @Override
    public boolean NodeExist(String source, String destination) {
        return false;
    }

    @Override
    public Node loadNode(String source, String destination) {
        return null;
    }

    @Override
    public RouteLinkedList initList() {
        return null;
    }

    @Override
    public void saveNodeToDB(String source, String destination) {

    }

    @Override
    public void saveListToDB(RouteLinkedList list) {

    }

    @Override
    public Point saveProductLocationToDB(Point point, String name) {
        return null;
    }
}
