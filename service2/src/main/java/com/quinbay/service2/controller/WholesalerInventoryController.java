package com.quinbay.service2.controller;


import com.quinbay.service2.model.Wholesaler;
import com.quinbay.service2.model.WholesalerInventory;
import com.quinbay.service2.service.WholesalerInventoryOp;
import com.quinbay.service2.service.WholesalerOp;
import com.quinbay.service2.service2Repository.WholesalerInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/wholesalerInventory")
public class WholesalerInventoryController {
    @Autowired
    WholesalerInventoryOp wholesalerIn;

    @GetMapping("/getWholesalerIn")
    public ArrayList<WholesalerInventory> get_wholeIn(){
        return wholesalerIn.disp_wholesalerIn();
    }

    @GetMapping("/getWholesalerIn/{id}")
    public WholesalerInventory get_WholeIn_byId(@RequestParam int id){
        return wholesalerIn.get_wholesalerIn_byId(id);
    }

    @PostMapping("/addWholesalerIn")
    public WholesalerInventory add_wholeIn(@RequestBody WholesalerInventory a)
    {
        return wholesalerIn.add_wholesalerIn(a);
    }

    @PutMapping("/updateWholesalerIn")
    public ResponseEntity<String> add_wholeIn(@RequestParam int id, @RequestParam int val)
    {
        return wholesalerIn.update_wholesalerIn(id, val);
    }
    //
    @DeleteMapping("/deleteWholesalerIn/{id}")
    public String det_wholeIn(@RequestParam int id) {
        return wholesalerIn.remove_wholesalerIn(id);

    }
}
