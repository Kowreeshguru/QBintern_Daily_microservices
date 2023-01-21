package com.quinbay.service2.model;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Wholesaler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique =true)
    int w_id;
    @Column
    String w_name;
    Wholesaler(){}

    public int getW_id() {
        return w_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;

    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public Wholesaler(int id, String name){

        this.w_id=id;
        this.w_name=name;

    }
}
