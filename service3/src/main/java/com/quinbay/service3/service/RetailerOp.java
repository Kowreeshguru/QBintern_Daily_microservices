package com.quinbay.service3.service;

import com.quinbay.service3.model.Product;
import com.quinbay.service3.model.Retailer;
import com.quinbay.service3.model.Wholesaler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RetailerOp
{
    public static ArrayList<Retailer> retailer = new ArrayList<>();
    public Retailer disp_retailer(int id) {
        Retailer ans = null;
        for (Retailer temp_retail : retailer) {
            if (temp_retail.getR_id() == id) {
                ans = temp_retail;
            }
        }
        return ans;
    }

    public Retailer add_retailer(Retailer add_retail) {
//        for(Wholesaler whole: add_whole){
        retailer.add(add_retail);
//        }
//        wholesaler.add(whole);
        return add_retail;
    }

    public void upd_retailer(int id, String name){
        for(Retailer temp_retail: retailer) {
            if (temp_retail.getR_id() == id) {
                temp_retail.setW_name(name);
            }
        }
    }

    public void allocate_wholesaler(int rid,Wholesaler whole, Product prod, int val){
        System.out.println("inside");
        for(Retailer temp_retail: retailer) {
            if (temp_retail.getR_id() == rid) {
                System.out.println("retail");
                if(temp_retail.retail_wholesalerlist.isEmpty()){
                    temp_retail.retail_wholesalerlist.add(whole);
                }
                else {
                    boolean flag=true;
                    for(Wholesaler temp_whole:temp_retail.retail_wholesalerlist){
                        if(temp_whole.getW_id()==whole.getW_id()){
                            flag=false;
                            prod.stock=val;
                            temp_whole.whole_productlist.add(prod);
                        }
                    }
                    if(!flag){
                        prod.stock=val;
                        whole.whole_productlist.add(prod);
                        temp_retail.retail_wholesalerlist.add(whole);
                    }
                }
            }
        }
    }

    public void remove_retailer(int id){
        for(Retailer temp_whole: retailer) {
            if(temp_whole.getR_id() == id) {
                retailer.remove(temp_whole);
            }
        }
    }
}
//for (Wholesaler temp_whole : temp_retail.retail_wholesalerlist) {
//        if (temp_whole.getW_id() == whole.getW_id()) {
//
//        if (temp_whole.getWhole_productlist().isEmpty()) {
//        prod.stock = val;
//        temp_whole.getWhole_productlist().add(prod);
//        } else {
//        for (Product temp_product : temp_whole.getWhole_productlist()) {
//        if (temp_product.id == prod.id) {
//        temp_product.stock = temp_product.stock + val;
//        } else {
//        temp_whole.getWhole_productlist().add(prod);
//        }
//        }
//        }
//        }
//        }