package com.quinbay.service3.Interface;

import com.quinbay.service3.model.RetailerInventory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RetailerInventoryInterface {
    ArrayList<RetailerInventory> disp_retailIn();
    RetailerInventory add_retailIn(RetailerInventory retailIn);
    RetailerInventory get_retailIn_byId(int id);
    //    void update_producr(int id,int val);
    String remove_retailIn(int id);
}
