package com.magicdate.pesometer.DataBaseObjects;

import android.util.Pair;

import com.magicdate.pesometer.NavigationElements.CycleLinkedList;
import com.magicdate.pesometer.NavigationElements.Path;
import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.NavigationElements.Point;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    private LinkedList<PathNode> product_names; // BUILD FROM PATHNODE
    private LinkedList<Path> pointsAlongPath;

    public ShoppingPathDataBase(){
        TITLE += setDate();
        product_names = new LinkedList<>();
        pointsAlongPath = new LinkedList<>();
    }


    private String setDate (){
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//formating according to my need
        String date = formatter.format(today);
        return date;

    }

    public void setProduct_names(List<PathNode> product_stops) {
        for (PathNode pair : product_stops)
        {
            this.product_names.add(pair);
        }
    }

    public String getStartTime() {
        return TITLE;
    }
}
