package com.example;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Zoltan Altfatter
 */
@Component
public class Consumer {

    @KafkaListener(topics = "test")
    public void handle(String message) {
        System.out.println(message);
    }

}
