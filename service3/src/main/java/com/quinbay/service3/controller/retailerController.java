package com.quinbay.service3.controller;

import com.quinbay.service3.model.Retailer;
import com.quinbay.service3.service.RetailerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/retailer")
public class RetailerController {

    @Autowired
    RetailerOp retailer;

    @GetMapping("/getretailer")
    public ArrayList<Retailer> get_retail(){
        return retailer.disp_retail();
    }

    @GetMapping("/getRetail/{id}")
    public Retailer get_retail_byId(@RequestParam int id){
        return retailer.get_retail_byId(id);
    }

    @PostMapping("/addRetailer")
    public Retailer add_prod(@RequestBody Retailer a)
    {
        return retailer.add_retail(a);
    }

    @PutMapping("/updateRetail")
    public ResponseEntity<String> add_wareIn(@RequestParam int id, @RequestParam String val)
    {
        return retailer.update_retail(id, val);
    }
    //
    @DeleteMapping("/deleteRetail/{id}")
    public String det_retail(@RequestParam int id) {
        return retailer.remove_retail(id);

    }
}
