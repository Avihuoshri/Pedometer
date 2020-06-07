package com.magicdate.pesometer.DataBaseObjects;

import com.magicdate.pesometer.NavigationElements.PathTracker;

import java.util.HashMap;
import java.util.Map;

public class StroreBranchDataBase {

    String name;
    PathTracker pathTracker;
    private Map<String, Object> productsOfBranch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StroreBranchDataBase() {
        productsOfBranch = new HashMap<>();
    }

    public Map<String, Object> getProductsOfBranch() {
        return productsOfBranch;
    }

    public void setPathTracker(PathTracker pathTracker) {
        this.pathTracker = pathTracker;
    }
}
