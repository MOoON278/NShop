package com.example.nshopmainmenu;

public class shoppingcartproduct {
    // Variable to store data corresponding
    // to firstname keyword in database
    private String productName;

    // Variable to store data corresponding
    // to lastname keyword in database
    private String productQuantity;

    // Variable to store data corresponding
    // to age keyword in database
    private String productPrice;

    // Mandatory empty constructor
    // for use of FirebaseUI
    public shoppingcartproduct() {}

    // Getter and setter method
    public String getProductName()
    {
        return productName;
    }
    public void setProductName(String x)
    {
        this.productName = x;
    }
    public String getProductQuantity()
    {
        return productQuantity;
    }
    public void setProductQuantity(String x)
    {
        this.productQuantity = x;
    }
    public String getProductPrice()
    {
        return productPrice;
    }
    public void setProductPrice(String age)
    {
        this.productPrice = age;
    }
}
