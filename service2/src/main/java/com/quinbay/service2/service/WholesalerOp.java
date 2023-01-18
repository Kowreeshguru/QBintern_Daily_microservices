package com.quinbay.service2.service;

import com.quinbay.service2.model.Product;
import com.quinbay.service2.model.Wholesaler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class WholesalerOp {
    public static ArrayList<Wholesaler> wholesaler = new ArrayList<>();
    public Wholesaler disp_wholesaler(int id) {
        Wholesaler ans = null;
        for (Wholesaler temp_whole : wholesaler) {
            if (temp_whole.getW_id() == id) {
                ans = temp_whole;
            }
        }
        return ans;
    }

    public Wholesaler add_wholesaler(Wholesaler add_whole) {
//        for(Wholesaler whole: add_whole){
            wholesaler.add(add_whole);
//        }
//        wholesaler.add(whole);
        return add_whole;
    }

    public void upd_wholesaler(int id, String name){
        for(Wholesaler temp_whole: wholesaler) {
            if (temp_whole.getW_id() == id) {
                temp_whole.setW_name(name);
            }
        }
    }

    public void allocate_wholesaler(int wid,Product prod,int val){
        System.out.println("inside");
        for(Wholesaler temp_whole: wholesaler) {
            if (temp_whole.getW_id() == wid) {
                System.out.println("whole");
                if(temp_whole.getWhole_productlist().isEmpty()){
                    prod.stock=val;
                    temp_whole.getWhole_productlist().add(prod);
                }
                else {
                    for (Product temp_product : temp_whole.getWhole_productlist()) {
                        if (temp_product.id == prod.id) {
                            temp_product.stock = temp_product.stock + val;
                        } else {
                            temp_whole.getWhole_productlist().add(prod);
                        }
                    }
                }
            }
        }
    }

    public void update_stock(int wid,int pid,int val){
        for(Wholesaler temp_whole:wholesaler){
            if(temp_whole.getW_id()==wid){
                for(Product prod:temp_whole.getWhole_productlist()){
                    if(prod.id==pid){
                        prod.stock=prod.stock-val;
                    }
                }
            }
        }
    }

    public void remove_wholesaler(int id){
        for(Wholesaler temp_whole: wholesaler) {
            if(temp_whole.getW_id() == id) {
                wholesaler.remove(temp_whole);
            }
        }
    }
}
