package com.quinbay.service3.service;

import com.quinbay.service3.Interface.RetailerInterface;
import com.quinbay.service3.Interface.RetailerInventoryInterface;
import com.quinbay.service3.Repository.RetailerInventoryRepository;
import com.quinbay.service3.model.RetailerInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RetailerInventoryOp implements RetailerInventoryInterface {
    @Autowired
    RetailerInventoryRepository retailInrepo;

//    public static ArrayList<Product> product = new ArrayList<>();
    @Override
    public ArrayList<RetailerInventory> disp_retailIn() {
        return (ArrayList<RetailerInventory>) retailInrepo.findAll();
    }

    public RetailerInventory add_retailIn(RetailerInventory add_retailIn) {
        return retailInrepo.save(add_retailIn);
    }
    public RetailerInventory get_retailIn_byId(int retialInId){
        try{
            return retailInrepo.findById(retialInId);
        }catch (Exception e){
            return null;
        }
    }
    public ResponseEntity<String> update_retailIn(int id, int val){
        try {
            RetailerInventory retailIn = retailInrepo.findById(id);
            retailIn.setPrice(val);
            retailInrepo.save(retailIn);
            return new ResponseEntity("Successfully update", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Not updated, Id not founded", HttpStatus.BAD_REQUEST);
        }
    }

    public String remove_retailIn(int id){
        try{
            retailInrepo.deleteById(id);
            return ("Deleted successfully");
        }catch(Exception e){
            return ("Not deleted");
        }

    }
}
