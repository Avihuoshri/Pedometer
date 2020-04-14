package com.magicdate.pesometer.interfaces;

import com.magicdate.pesometer.navigation.Point;
import com.magicdate.pesometer.navigation.RouteLinkedList;

public interface Record{

    //initialize new list of routes.
    public RouteLinkedList initList();

    //save product point on the map
    public Point saveProductLocationToDB(Point point, String name);

    //save new node in the database of routes.
    public void saveNodeToDB(String source, String destination);

    //save all the routes when finish shopping.
    public void saveListToDB(RouteLinkedList list);
}
