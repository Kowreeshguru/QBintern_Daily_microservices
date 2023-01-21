package com.quinbay.service3.controller;

import com.quinbay.service3.model.Retailer;
import com.quinbay.service3.model.RetailerInventory;
import com.quinbay.service3.service.RetailerInventoryOp;
import com.quinbay.service3.service.RetailerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/retailerIn")
public class RetailerInventoryController {
    @Autowired
    RetailerInventoryOp retailerIn;

    @GetMapping("/getRetailerIn")
    public ArrayList<RetailerInventory> get_retailIn(){
        return retailerIn.disp_retailIn();
    }

    @GetMapping("/getRetailIn/{id}")
    public RetailerInventory get_retailIn_byId(@RequestParam int id){
        return retailerIn.get_retailIn_byId(id);
    }

    @PostMapping("/addRetailIn")
    public RetailerInventory add_retailerIn(@RequestBody RetailerInventory a)
    {
        return retailerIn.add_retailIn(a);
    }

    @PutMapping("/updateRetailIn")
    public ResponseEntity<String> add_RetailIn(@RequestParam int id, @RequestParam int val)
    {
        return retailerIn.update_retailIn(id, val);
    }
    //
    @DeleteMapping("/deleteRetailIn/{id}")
    public String det_retailIn(@RequestParam int id) {
        return retailerIn.remove_retailIn(id);

    }
}
