package com.quinbay.service1.service;

import com.quinbay.service1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductOp {
    public static ArrayList<Product> product = new ArrayList<>();
    public Product disp_product(int id) {
        Product ans=null;
        for (Product prod : product) {
            if (prod.id == id) {
                ans=prod;
            }
        }return ans;
    }
    public Product add_product(Product add_prod) {
        product.add(add_prod);
//        add_prod.setStatus("Success");
        return add_prod;
    }
    public void mang_warehouse(int id,int val){
        for(Product temo_product: product) {
            if(temo_product.id == id) {
                temo_product.stock = temo_product.stock - val;
            }
        }
    }

    public void remove_prod(int id){
        for(Product temp_product: product) {
            if(temp_product.id == id) {
                product.remove(temp_product);
            }
        }
    }
}
