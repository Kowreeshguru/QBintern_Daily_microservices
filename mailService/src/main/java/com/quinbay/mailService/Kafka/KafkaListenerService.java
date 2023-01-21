package com.quinbay.mailService.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.quinbay.mailService.models.BillDetails;
import com.quinbay.mailService.models.Product;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    public  BillDetails bill=null;

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics="send.productInfo",groupId="warehouse")
    public void getWholesalerInfo(ConsumerRecord<?,String> consumerRecord){

        try{
            bill = objectMapper.readValue(consumerRecord.value(),new com.fasterxml.jackson.core.type.TypeReference<BillDetails>(){

            });
            System.out.println(bill.getP_name());
        }catch (Exception e){

        }
    }
}
