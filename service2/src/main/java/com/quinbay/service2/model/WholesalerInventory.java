package com.quinbay.service2.model;


import javax.persistence.*;

@Entity
public class WholesalerInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    int w_id;
    @Column
    int ware_id;
    @Column
    int p_id;
    @Column
    int stock;
    @Column
    int price;

    WholesalerInventory(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getWare_id() {
        return ware_id;
    }

    public void setWare_id(int ware_id) {
        this.ware_id = ware_id;
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

    public WholesalerInventory(int id,int w_id,int ware_id, int stock,int price){
        this.id=id;
        this.w_id=w_id;
        this.ware_id=ware_id;
        this.stock=stock;
        this.price=price;
    }
}
