package com.quinbay.service2.controller;


import com.quinbay.service2.model.Wholesaler;
import com.quinbay.service2.service.WholesalerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/wholesaler")
class WholesalerController {
    @Autowired
    WholesalerOp wholesaler;

    @GetMapping("/getWholesaler")
    public ArrayList<Wholesaler> get_whole(){
        return wholesaler.disp_wholesaler();
    }

    @GetMapping("/getWholesaler/{id}")
    public Wholesaler get_Whole_byId(@RequestParam int id){
        return wholesaler.get_wholesaler_byId(id);
    }

    @PostMapping("/addWholesaler")
    public Wholesaler add_whole(@RequestBody Wholesaler a)
    {
        return wholesaler.add_wholesaler(a);
    }

    @PutMapping("/updateWholesaler")
    public ResponseEntity<String> add_whole(@RequestParam int id, @RequestParam String val)
    {
        return wholesaler.update_wholesaler(id, val);
    }
    //
    @DeleteMapping("/deleteWholesaler/{id}")
    public String det_whole(@RequestParam int id) {
        return wholesaler.remove_wholesaler(id);

    }
}