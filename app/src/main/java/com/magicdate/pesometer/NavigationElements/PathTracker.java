package com.magicdate.pesometer.NavigationElements;

import com.magicdate.pesometer.interfaces.Navigate;
import com.magicdate.pesometer.interfaces.Record;

import java.io.Serializable;
import java.util.ArrayList;

public class PathTracker implements Record, Navigate, Serializable {
    public Point firstPoint;
    public Path firstPath;
    public CycleLinkedList list;

    public PathTracker(){
    }

    @Override
    public void initList() {
        firstPoint = new Point(50,50);
        firstPath = new Path();
        list = new CycleLinkedList();

        firstPath.add(firstPoint);
        list.add(firstPath);
        list.head.setSource("enter");
        list.head.setDestination("enter");
    }

    public void saveRoute(ArrayList<Float> degrees, String destination) {

        //get last point
        Path lastPath = list.tail.getPath();
        int lastRouteSize = lastPath.size();
        Point lastPoint = lastPath.getPoints().get(lastRouteSize-1);

        //set first point of new path
        Path path = new Path();
        path.add(lastPoint);

        //add points to new path
        for(int i = 0; i<degrees.size(); i++){
            Point point = path.DegreeToPoint(degrees.get(i));
            path.add(point);
        }

        list.add(path);

        //set source and destination
        String source = list.tail.prev.getDestination();
        list.tail.setSource(source);
        list.tail.setDestination(destination);

    }

    @Override
    public String toString() {
        return "PathTracker{" +
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
    public PathNode loadNode(String source, String destination) {
        return null;
    }

    @Override
    public void saveNodeToDB(String source, String destination) {

    }

    @Override
    public void saveListToDB(CycleLinkedList list) {

    }

    @Override
    public Point saveProductLocationToDB(Point point, String name) {
        return null;
    }


}
