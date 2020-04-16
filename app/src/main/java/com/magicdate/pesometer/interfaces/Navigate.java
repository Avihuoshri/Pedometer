package com.magicdate.pesometer.interfaces;

import com.magicdate.pesometer.NavigationElements.PathNode;

public interface Navigate {

    //check if Noude exsist in the DB (by the source and destination).
    public boolean NodeExist(String source, String destination);

    //load Node from the DB.
    public PathNode loadNode(String source, String destination);
}
