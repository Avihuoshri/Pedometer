package com.magicdate.pesometer.SuperMarketObjects;

import java.util.ArrayList;

public class Department
{
    private String departmentName ;
    private ArrayList<ProductNode> depProductsList ;
    private ArrayList<ProductNode> saleList ;


    public Department(String departmentName)
    {
        this.departmentName = departmentName ;
        depProductsList = new ArrayList<>() ;
        saleList = new ArrayList<>() ;
    }

    public void addProductToDeaprtment(ProductNode product)
    {
        if(!depProductsList.contains(product)) {
            depProductsList.add(product);
        }
    }

    public void addtoSaleList(ProductNode product)
    {
        if(!saleList.contains(product) && product.getOnSale()) {
            saleList.add(product);
        }
    }

}
