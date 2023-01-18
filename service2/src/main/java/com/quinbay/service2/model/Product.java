package com.quinbay.service2.model;

public class Product {
    public int id;
    public String name;
    public int stock;
    public int price;
    public int gst;
    public Product(){}
    public Product(int id, String name, int stock, int price, int gst){
        this.id=id;
        this.name=name;
        this.stock=stock;
        this.price=price;
        this.gst=gst;
    }
}
