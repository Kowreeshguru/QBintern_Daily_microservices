package com.quinbay.service1.controller;


import com.quinbay.service1.model.Product;
import com.quinbay.service1.service.ProductOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductOp product;

    @GetMapping("/getProduct")
    public Product get_prod(@RequestParam int a) {
        return product.disp_product(a);
    }

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product add_prod(@RequestBody Product a) {
        return product.add_product(a);
    }
    @PutMapping("/updateProduct")
    public String  upd_prod(@RequestParam int id,@RequestParam int val) {
        product.mang_warehouse(id,val);
        return "Product updated successfully";
    }

    @DeleteMapping("/deleteProduct")
    public String det_prod(@RequestParam int id) {
        product.remove_prod(id);
        return "Product deleted successfully";
    }

}
