package com.quinbay.service3.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.service3.model.BillDetails;
import com.quinbay.service3.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublishingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTempltae;

    public void retailerInformation(BillDetails del){
        try{
            kafkaTempltae.send("send.RetailerInfo",this.objectMapper.writeValueAsString(del));
        }catch(Exception e){
            System.out.println("Error is publishing"+e);
        }
    }
}
