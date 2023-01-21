package com.quinbay.service2.service;


import com.quinbay.service2.Interface.WholesalerInterface;
import com.quinbay.service2.Interface.WholesalerInventoryInterface;
import com.quinbay.service2.model.Wholesaler;
import com.quinbay.service2.model.WholesalerInventory;
import com.quinbay.service2.service2Repository.WholesalerInventoryRepository;
import com.quinbay.service2.service2Repository.WholesalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.ArrayList;

@Service
public class WholesalerInventoryOp implements WholesalerInventoryInterface {
    @Autowired
    WholesalerInventoryRepository wholeInrepo;

//    public static ArrayList<Wholesaler> wholwsa = new ArrayList<>();
    @Override
    public ArrayList<WholesalerInventory> disp_wholesalerIn() {
        return (ArrayList<WholesalerInventory>) wholeInrepo.findAll();
    }

    public WholesalerInventory add_wholesalerIn(WholesalerInventory add_wholeIn) {
        return wholeInrepo.save(add_wholeIn);
    }
    public WholesalerInventory get_wholesalerIn_byId(int wholesalerInId){
        try {
            return wholeInrepo.findById(wholesalerInId);
        }catch (Exception e){
            return null;
        }

    }
    public ResponseEntity<String> update_wholesalerIn(int id, int val){
        try {
            WholesalerInventory wholesalerIn = wholeInrepo.findById(id);
            wholesalerIn.setPrice(val);
            wholeInrepo.save(wholesalerIn);
            return new ResponseEntity("Successfully update",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Not updated, Id not found",HttpStatus.BAD_REQUEST);
        }

    }

    public String remove_wholesalerIn(int id){
        try{
            wholeInrepo.deleteById(id);
            return ("Deleted successfully");
        }catch(Exception e){
            return ("Not deleted");
        }

    }
}
