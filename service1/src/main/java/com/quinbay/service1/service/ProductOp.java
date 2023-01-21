package com.quinbay.service1.service;

import com.quinbay.service1.Interface.ProductInterface;
import com.quinbay.service1.Kafka.KafkaPublishingService;
import com.quinbay.service1.Repository.ProductRepository;
import com.quinbay.service1.model.BillDetails;
import com.quinbay.service1.model.Product;
import com.quinbay.service1.model.warehouse_inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductOp implements ProductInterface {

    @Autowired
    ProductRepository proRepo;
    @Autowired
    KafkaPublishingService kafkaPublishingService;

//    public static ArrayList<Product> product = new ArrayList<>();
    @Override
    public ArrayList<Product> disp_product() {
        return (ArrayList<Product>) proRepo.findAll();
    }
    @Override
    public Product add_product(Product add_prod) {
        return proRepo.save(add_prod);
    }
    @Override
    public Product get_product_byId(int productId){
        Product product=proRepo.findById(productId);
        BillDetails det= new BillDetails("Warehouse1",101,"iphone13",70000,65000,18,73000);
        kafkaPublishingService.productInformation(det);
        try {
            return proRepo.findById(productId);
        }catch(Exception e){
            return null;
        }
    }
    public ResponseEntity<String> update_Product(int id, String name,int price){
        try {
            Product product = proRepo.findById(id);
            product.setName(name);
            product.setPrice(price);
            proRepo.save(product);
            return new ResponseEntity("Successfully update", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("Not updated, Id not found", HttpStatus.BAD_REQUEST);
        }
    }

    public String remove_product(int id){
        try{
            proRepo.deleteById(id);
            return ("Deleted successfully");
        }catch(Exception e){
            return ("Not deleted");
        }

    }
}
