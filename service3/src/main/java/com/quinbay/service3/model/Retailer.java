package com.quinbay.service3.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique= true)
    public  int r_id;
    @Column
    String r_name;
    Retailer(){}


    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Retailer(int id, int r_id,String name){
        this.r_id=id;
        this.id=id;
        this.r_name=name;

    }
}
