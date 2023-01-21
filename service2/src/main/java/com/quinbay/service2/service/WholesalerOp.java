package com.quinbay.service2.service;

import com.quinbay.service2.Interface.WholesalerInterface;
import com.quinbay.service2.Kafka.KafkaPublishingService;
import com.quinbay.service2.model.BillDetails;
import com.quinbay.service2.model.Wholesaler;
import com.quinbay.service2.model.WholesalerInventory;
import com.quinbay.service2.service2Repository.WholesalerInventoryRepository;
import com.quinbay.service2.service2Repository.WholesalerRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.SplittableRandom;

@Service
public class WholesalerOp implements WholesalerInterface {
    @Autowired
    WholesalerRepository wholerepo;
    @Autowired
    KafkaPublishingService kafkaPublishingService;

    //    public static ArrayList<Wholesaler> wholwsa = new ArrayList<>();
    @Override
    public ArrayList<Wholesaler> disp_wholesaler() {
        return (ArrayList<Wholesaler>) wholerepo.findAll();
    }

    public Wholesaler add_wholesaler(Wholesaler add_whole) {
        return wholerepo.save(add_whole);
    }
//    @KafkaListener(topics="send.productInfo", groupId="warehouse")
//    public void getProductInfo(ConsumerRecord<?,String> consumerRecord){
//        Pr
//    }
    public Wholesaler get_wholesaler_byId(int wholesalerId){
        try {
            BillDetails det= new BillDetails("Warehouse1",231,"iphone12",65000,61000,18,69000);
            kafkaPublishingService.wholesalerInformation(det);
            return wholerepo.findById(wholesalerId);
        }catch (Exception e){
            return  null;
        }

    }
    public ResponseEntity<String> update_wholesaler(int id, String val){
        try {
            Wholesaler wholesaler = wholerepo.findById(id);
            wholesaler.setW_name(val);
            wholerepo.save(wholesaler);
            return new ResponseEntity("Successfully update",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Not updated, Id not found",HttpStatus.BAD_REQUEST);
        }

    }

    public String remove_wholesaler(int id){
        try{
            wholerepo.deleteById(id);
            return ("Deleted successfully");
        }catch(Exception e){
            return ("Not deleted");
        }

    }
}
