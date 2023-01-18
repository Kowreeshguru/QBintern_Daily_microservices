package com.quinbay.service3.model;

import java.util.ArrayList;

public class Retailer {
    public  int r_id;
    String r_name;
    public ArrayList<Wholesaler> retail_wholesalerlist=new ArrayList<>();
    Retailer(){}

    public int getR_id() {
        return r_id;
    }

    public void setW_id(int r_id) {
        this.r_id = r_id;
    }

    public ArrayList<Wholesaler> getRetail_wholesalerlist() {
        return retail_wholesalerlist;
    }

    public void setRetail_wholesalerlist(ArrayList<Wholesaler> retail_wholesalerlist) {
        this.retail_wholesalerlist = retail_wholesalerlist;
    }

    public String getR_name() {
        return r_name;
    }

    public void setW_name(String r_name) {
        this.r_name = r_name;
    }



    public Retailer(int id, String name){
        this.r_id=id;
        this.r_name=name;
        this.retail_wholesalerlist= new ArrayList<Wholesaler>();
//        Product prod1=new Product(100,"iphone12",1000,45000,12);
//        Product prod2=new Product(101,"iphone13",1000,50000,15);
//        retail_productlist.add(prod1);
//        retail_productlist.add(prod2);
    }
}
