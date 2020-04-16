package com.magicdate.pesometer.navigation;

import android.util.Log;

import com.magicdate.pesometer.interfaces.Navigate;
import com.magicdate.pesometer.interfaces.Record;

import java.util.ArrayList;

public class RouteTracker implements Record, Navigate {
    public Point firstPoint;
    public Route firstRoute;
    public RouteLinkedList list;

    public RouteTracker(){
    }

    @Override
    public void initList() {
        firstPoint = new Point(1000,1000);
        firstRoute = new Route();
        list = new RouteLinkedList();

        firstRoute.add(firstPoint);
        list.add(firstRoute);
        list.head.setSource("enter");
        list.head.setDestination("enter");
    }

    public void saveRoute(ArrayList<Float> degrees, String destination) {

        //get last point
        Route lastRoute= list.tail.getRoute();
        int lastRouteSize = lastRoute.size();
        Point lastPoint = lastRoute.getPoints().get(lastRouteSize-1);

        //set first point of new route
        Route route = new Route();
        route.add(lastPoint);

        //add points to new route
        for(int i = 0; i<degrees.size(); i++){
            Point point = route.DegreeToPoint(degrees.get(i));
            route.add(point);
        }

        list.add(route);

        //set source and destination
        String source = list.tail.prev.getDestination();
        list.tail.setSource(source);
        list.tail.setDestination(destination);

    }

    @Override
    public String toString() {
        return "RouteTracker{" +
                "list=" + list.toString() +
                '}';
    }

    public String ProductsToString() {
        return list.sourceDestToString();
    }

    @Override
    public boolean NodeExist(String source, String destination) {
        return false;
    }

    @Override
    public Node loadNode(String source, String destination) {
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
