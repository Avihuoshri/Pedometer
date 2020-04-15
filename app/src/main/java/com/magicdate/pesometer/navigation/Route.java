package com.magicdate.pesometer.navigation;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Route  {
    private ArrayList<Point> points;

    public Route() {
        this.points = new ArrayList<>();
    }

    //convert degree that comes from the senssor to point on the route
    public Point DegreeToPoint(float degree){
        //get the coordinate of the lest point on the route
        if(points.size() != 0) {
            int i = points.get(points.size()-1).getI();
            int j = points.get(points.size()-1).getJ();

            //not a valid degree
            if (degree < 0 || degree > 360) {
                return null;
            }
            // 1) go up on the map
            else if (degree < 26 || degree > 339) {
                return new Point(i - 1, j);
            }
            // 2) go right up diagonal on the map
            else if (degree < 64) {
                return new Point(i - 1, j + 1);
            }
            // 3) go right on the map
            else if (degree < 109) {
                return new Point(i, j + 1);
            }
            // 4) go right down diagonal on the map
            else if(degree < 154){
                return new Point(i + 1, j + 1);
            }
            // 5) go down on the map
            else if(degree < 199){
                return new Point(i + 1, j);
            }
            // 6) go left down diagonal on the map
            else if(degree < 244){
                return new Point(i + 1, j - 1);
            }
            // 7) go left on the map
            else if(degree < 289){
                return new Point(i, j - 1);
            }
            // 8) go left up diagonal on the map
            else{
                return new Point(i - 1, j - 1);
            }
        }
        return  null;
    }


    public void add(Point point) {
        points.add(point);
    }

    public int size(){
        return points.size();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public String toString() {
        return "Route{" +
                "points=" + points.toString() +
                ", size=" + points.size() +
                '}';
    }

}
