package com.thecodeveal.app.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    final String groupIdValue = "mygroup";

//    @Autowired
//    OrderRepository orderRepository;

    @KafkaListener(topics="orderStatusChange", groupId= groupIdValue)
    public void consumeFromOrderStatusChange(String msg) throws JsonProcessingException {
        System.out.println(msg);
    }
}
