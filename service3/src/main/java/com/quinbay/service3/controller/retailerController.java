package com.quinbay.service3.controller;

import com.quinbay.service3.model.Product;
import com.quinbay.service3.model.Retailer;
import com.quinbay.service3.model.Wholesaler;
import com.quinbay.service3.service.RetailerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/retailer")
public class retailerController {
    @Autowired
    RetailerOp retail;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getRetailer")
    public Retailer get_ret(@RequestParam int a) {
        return retail.disp_retailer(a);
    }

    @PostMapping("/addRetailer")
    @ResponseStatus(HttpStatus.CREATED)
    public Retailer add_ret(@RequestBody Retailer a) {
        return retail.add_retailer(a);
    }
    @PutMapping("/updateRetailer")
    public String  upd_prod(@RequestParam int id,@RequestParam String val) {
        retail.upd_retailer(id,val);
        return "Wholesaler updated successfully";
    }

    @DeleteMapping("/deleteRetailer")
    public String det_prod(@RequestParam int id) {
        retail.remove_retailer(id);
        return "Wholesaler deleted successfully";
    }

    @PostMapping("/allocateRetailer")
    public String add_service(@RequestParam int rid,@RequestParam int wid,@RequestParam int pid,@RequestParam int val ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        String url= UriComponentsBuilder.fromHttpUrl("http://localhost:8080/product").queryParam("id",wid).queryParam("val",val).toUriString();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Wholesaler whole=restTemplate.exchange("http://localhost:8080/product/getWholesaler?a="+wid,HttpMethod.GET,entity ,Wholesaler.class).getBody();
        Product prod=restTemplate.exchange("http://localhost:8080/product/getProduct?a="+pid,HttpMethod.GET,entity ,Product.class).getBody();
        retail.allocate_wholesaler(rid,whole,prod,val);
//        return restTemplate.exchange(url,HttpMethod.PUT,entity ,String.class).getBody();
        return null;
    }
}
