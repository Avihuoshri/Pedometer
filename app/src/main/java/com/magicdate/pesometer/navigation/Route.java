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

public class Route implements List<Point> {
    private ArrayList<Point> points;
    private int size;

    public Route() {
        this.points = new ArrayList<Point>();
    }

    //convert degree that comes from the senssor to point on the route
    public Point DegreeToPoint(float degree){
        int i = 1000;
        int j = 1000;
        //get the coordinate of the lest point on the route
        if(points.size() != 0) {

             i = points.get(size-1).getI();
             j = points.get(size-1).getJ();

            //not a valid degree
            if (degree < 0 || degree > 360) {
                return null;
            }
            //go up on the map
            else if (degree < 45 || degree > 315) {
                return new Point(i - 1, j);
            }
            //go up right the map
            else if (degree < 135) {
                return new Point(i, j + 1);
            }
            //go down on the map
            else if (degree < 225) {
                return new Point(i + 1, j);
            }
            //go left on the map
            else {
                return new Point(i, j - 1);
            }
        }
        return  new Point(i,j);
    }

    //add new point on the route by the step direction
    public void add(float degree) {
        Point newPoint = DegreeToPoint(degree);
        this.add(newPoint);
    }


    @Override
    public String toString() {
        return "Route{" +
                "points=" + points.toString() +
                ", size=" + size +
                '}';
    }


    @Override
    public boolean add(Point point) {
        try{
            points.add(point);
            size++;
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(points.isEmpty())
            return true;
        return false;
    }

    @Override
    public boolean contains(@Nullable Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<Point> iterator() {
        return null;
    }

    @Override
    public void forEach(@NonNull Consumer<? super Point> action) {

    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] a) {
        return null;
    }

    @Override
    public boolean remove(@Nullable Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends Point> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends Point> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(@NonNull Predicate<? super Point> filter) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(@NonNull UnaryOperator<Point> operator) {

    }

    @Override
    public void sort(@Nullable Comparator<? super Point> c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(@Nullable Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Point get(int index) {
        return null;
    }

    @Override
    public Point set(int index, Point element) {
        return null;
    }

    @Override
    public void add(int index, Point element) {

    }

    @Override
    public Point remove(int index) {
        return null;
    }

    @Override
    public int indexOf(@Nullable Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<Point> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<Point> listIterator(int index) {
        return null;
    }

    @NonNull
    @Override
    public List<Point> subList(int fromIndex, int toIndex) {
        return null;
    }

    @NonNull
    @Override
    public Spliterator<Point> spliterator() {
        return null;
    }

    @NonNull
    @Override
    public Stream<Point> stream() {
        return null;
    }

    @NonNull
    @Override
    public Stream<Point> parallelStream() {
        return null;
    }

}
