package com.thecodeveal.app.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer{
    public static final String topic = "orderStatusChange";

    @Autowired
    private KafkaTemplate<String, String> kafkaOrderStatus;

    public void orderStatusChangeTopic(String order) {
        System.out.println("producer msg");

        this.kafkaOrderStatus.send(topic,order);
    }
}
