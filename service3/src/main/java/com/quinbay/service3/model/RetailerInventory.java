package com.quinbay.service3.model;

import javax.persistence.*;

@Entity
public class RetailerInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    int r_id;
    @Column
    int w_id;
    @Column
    int p_id;
    @Column
    int stock;
    @Column
    int price;

    RetailerInventory(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    RetailerInventory(int id,int r_id,int w_id,int stock,int price){
        this.id=id;
        this.r_id=r_id;
        this.w_id=w_id;
        this.stock=stock;
        this.price=price;
    }
}
