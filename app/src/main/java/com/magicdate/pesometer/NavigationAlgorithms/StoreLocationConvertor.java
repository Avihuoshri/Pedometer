package com.magicdate.pesometer.NavigationAlgorithms;

import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.NavigationElements.Point;

interface StoreLocationConvertor {

    public PathNode Point2PathNode(Point point);
    public Point PathNode2Point(PathNode node);
}
