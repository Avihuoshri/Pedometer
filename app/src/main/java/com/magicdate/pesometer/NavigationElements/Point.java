package com.magicdate.pesometer.NavigationElements;

public class Point {
    private int i;
    private int j;

    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }

    public Point(Point point) {
        this.i = point.i;
        this.j = point.j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return "Point{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
