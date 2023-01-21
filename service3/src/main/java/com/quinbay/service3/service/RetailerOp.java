package com.quinbay.service3.service;

import com.quinbay.service3.Interface.RetailerInterface;
import com.quinbay.service3.Kafka.KafkaPublishingService;
import com.quinbay.service3.Repository.RetailerInventoryRepository;
import com.quinbay.service3.Repository.RetailerRepository;
import com.quinbay.service3.model.BillDetails;
import com.quinbay.service3.model.Retailer;
import com.quinbay.service3.model.RetailerInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RetailerOp implements RetailerInterface
{
    @Autowired
    RetailerRepository retailrepo;
    @Autowired
    KafkaPublishingService kafkaPublishingService;

    //    public static ArrayList<Product> product = new ArrayList<>();
    @Override
    public ArrayList<Retailer> disp_retail() {
        return (ArrayList<Retailer>) retailrepo.findAll();
    }

    public Retailer add_retail(Retailer add_retail) {
        return retailrepo.save(add_retail);
    }
    public Retailer get_retail_byId(int retialId){
        try {
            BillDetails det= new BillDetails("Warehouse1",311,"MacBook pro",165000,161000,18,169000);
            kafkaPublishingService.retailerInformation(det);
            return retailrepo.findById(retialId);
        }catch (Exception e){
            return null;
        }

    }
    public ResponseEntity<String> update_retail(int id, String val){
        try {
            Retailer retail = retailrepo.findById(id);
            retail.setR_name(val);
            retailrepo.save(retail);
            return new ResponseEntity("Successfully update",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Not updated, ID not found",HttpStatus.BAD_REQUEST);
        }

    }

    public String remove_retail(int id){
        try{
            retailrepo.deleteById(id);
            return ("Deleted successfully");
        }catch(Exception e){
            return ("Not deleted");
        }

    }
}