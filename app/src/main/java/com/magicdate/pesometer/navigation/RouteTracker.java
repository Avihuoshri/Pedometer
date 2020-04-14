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
        firstPoint = new Point(1000,1000);
        firstRoute = new Route();
        list = new RouteLinkedList();

    }

    @Override
    public void initList() {
        firstRoute.add(firstPoint);
        list.add(firstRoute);

    }

    /*
    //is mandatory to call the initList method **before** this method.
    public Route initRoute() {

        //get the prev route
        Route lastRoute = list.tail.getRoute();

        //get the last point in the last route
        int lastRouteSize = lastRoute.size();
        Point lastRoutePoint = lastRoute.get(lastRouteSize);

        //In case we want to create the first route in the list.
        if(lastRoutePoint.getI() == 0 && lastRoutePoint.getJ() ==0 ){
            lastRoutePoint.setI(1000);
            lastRoutePoint.setJ(1000);
        }

        //initialize new route with the last point
        //from prev route as the first point of
        //the current route

        Route newRoute = new Route();
        newRoute.add(lastRoutePoint);

        return newRoute;
    }
    */

    public void saveRoute(ArrayList<Float> degrees) {
        Route route = new Route();
        for(int i = 0; i<degrees.size(); i++){
            Point point = route.DegreeToPoint(degrees.get(i));
            route.add(point);
        }
        list.add(route);
        Log.d("first route ", list.toString());
    }

    @Override
    public String toString() {
        return "RouteTracker{" +
                "list=" + list.toString() +
                '}';
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
