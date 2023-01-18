package com.quinbay.service2.controller;


import com.quinbay.service2.model.Product;
import com.quinbay.service2.model.Wholesaler;
import com.quinbay.service2.service.WholesalerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/wholesaler")
class wholesalerController {
    @Autowired
    WholesalerOp whole;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getWholesaler")
    public Wholesaler get_prod(@RequestParam int a) {
        return whole.disp_wholesaler(a);
    }

    @PostMapping("/addWholesaler")
    @ResponseStatus(HttpStatus.CREATED)
    public Wholesaler add_prod(@RequestBody Wholesaler a) {
        return whole.add_wholesaler(a);
    }
    @PutMapping("/updateWholesaler")
    public String  upd_prod(@RequestParam int id,@RequestParam String val) {
        whole.upd_wholesaler(id,val);
        return "Wholesaler updated successfully";
    }

    @PutMapping("/buyfronmWholesaler")
    public String upd_prod(@RequestParam int wid,@RequestParam int pid,@RequestParam int val) {
        whole.update_stock(wid,pid,val);
        return "Wholesaler updated successfully";
    }

    @DeleteMapping("/deleteWholesaler")
    public String det_prod(@RequestParam int id) {
        whole.remove_wholesaler(id);
        return "Wholesaler deleted successfully";
    }

    @PostMapping("/allocateWholesaler")
    public String add_service(@RequestParam int wid,@RequestParam int pid,@RequestParam int val ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String url= UriComponentsBuilder.fromHttpUrl("http://localhost:8080/product/updateProduct").queryParam("id",wid).queryParam("val",val).toUriString();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Product prod=restTemplate.exchange("http://localhost:8080/product/getProduct?a="+pid,HttpMethod.GET,entity ,Product.class).getBody();
        whole.allocate_wholesaler(wid,prod,val);
        return restTemplate.exchange(url,HttpMethod.PUT,entity ,String.class).getBody();
    }
}
