package com.magicdate.pesometer.DataBaseObjects;

import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.NavigationElements.PathTracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingPathDataBase {
    /*
        DATE + TIME(hh\mm\ss) , where time is when you started.
        e.g :
                shoppingPath ( <date> ... <time>)
                    [i-1,i] :
                        P0
                        P1
                        P2
                        ..
                        ..
                        Pn
                     [i, i+1] :
                        P0
                        P1
                        P2
                        ..
                        ..
                        Pn
     */



    private String TITLE = "ShoppingList : ";
    private Map<String, Object> points;
    private Map<String, Object> from_tos;
    /*
    private LinkedList<PathNode> product_names; // BUILD FROM PATHNODE
    private LinkedList<Path> pointsAlongPath;
    */
    private PathTracker pathTracker;
    public ShoppingPathDataBase(){
        TITLE += setDate();
        //product_names = new LinkedList<>();
        //pointsAlongPath = new LinkedList<>();
        points = new HashMap<>();
        from_tos = new HashMap<>();
    }

    public Map<String, Object> getPoints() {
        return points;
    }

    public void setPathTracker(PathTracker pathTracker) {
        this.pathTracker = pathTracker;
    }

    public Map<String, Object> getFrom_tos() {
        return from_tos;
    }

    public PathTracker getPathTracker() {
        return pathTracker;
    }

    private String setDate (){
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//formating according to my need
        String date = formatter.format(today);
        return date;

    }
/*
    public void setProduct_names(PathTracker product_stops) {
        for (PathNode pair : product_stops)
        {
            this.product_names.add(pair);
        }
    }
*/
public void setProduct_names(PathTracker product_stops) {
    for (PathNode pair : product_stops.getList().getShoppingLists_srcDestOnly())
    {
        this.pathTracker.getList().getShoppingLists_srcDestOnly();
    }
    }

    public String getStartTime() {
        return TITLE+"/";
    }
}
