package com.quinbay.service2.Interface;

import com.quinbay.service2.model.WholesalerInventory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WholesalerInventoryInterface {
    ArrayList<WholesalerInventory> disp_wholesalerIn();
    WholesalerInventory add_wholesalerIn(WholesalerInventory wholesalerIn);
    WholesalerInventory get_wholesalerIn_byId(int id);
    //    void update_producr(int id,int val);
    String remove_wholesalerIn(int id);
}
