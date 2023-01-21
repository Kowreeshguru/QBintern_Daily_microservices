package com.quinbay.service1.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.service1.model.BillDetails;
import com.quinbay.service1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublishingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTempltae;

    public void productInformation(BillDetails details){
        try{
            kafkaTempltae.send("send.productInfo",this.objectMapper.writeValueAsString(details));
        }catch(Exception e){
            System.out.println("Error is publishing"+e);
        }
    }
}
