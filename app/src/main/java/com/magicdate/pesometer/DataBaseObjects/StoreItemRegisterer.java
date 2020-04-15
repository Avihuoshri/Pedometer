package com.magicdate.pesometer.DataBaseObjects;


import android.util.Pair;

import com.magicdate.pesometer.NavigationElements.Point;
import com.magicdate.pesometer.RealWorldObjects.ProductInStock;

public class StoreItemRegisterer {
    private ProductInStock productInStock;
    private Point locationPoint;

    public StoreItemRegisterer(){}
    public StoreItemRegisterer(String storeItemName,Point point) {
        productInStock = new ProductInStock(storeItemName);
        locationPoint = new Point(point);
    }
    public String getNameOfItem(){
        return productInStock.getNameOfProduct();
    }

    public void setNameOfProductInStock(String itemName) {
        this.productInStock.setNameOfProduct(itemName);
    }

    public void setLocationPoint(int i,int j) {
        this.locationPoint.setI(i);
        this.locationPoint.setJ(j);
    }
}
