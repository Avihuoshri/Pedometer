package com.magicdate.pesometer.SuperMarketObjects;

public class ProductNode {
    private String prodactName ;
    private String productDepartment ;
    private int productID ;
    private boolean OnSale ; // SHOULD SEPARATE PROCESS FROM THIS CLASS. A DB QUERY WOULD FIT.



    public ProductNode(String prodactName , String productDepartment , int productID)
    {
        this.prodactName = prodactName ;
        this.productDepartment = productDepartment ;
        this.productID = productID ;
        OnSale = false ;
    }

    public String getProdactName() {
        return prodactName;
    }

    public void setProdactName(String prodactName) {
        this.prodactName = prodactName;
    }

    public String getProductDepartment() {
        return productDepartment;
    }

    public void setProductDepartment(String productDepartment) {
        this.productDepartment = productDepartment;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public boolean getOnSale() {
        return OnSale;
    }

    public void setOnSale(boolean onSale) {
        OnSale = onSale;
    }
}
