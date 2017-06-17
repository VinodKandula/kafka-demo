package com.example;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Zoltan Altfatter
 */

@Component
public class Producer {

    // Spring’s KafkaTemplate is auto-configured
    private final KafkaTemplate kafkaTemplate;

    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelay = 1000)
    public void send() {
        kafkaTemplate.send("test", "Haliho" + new Date());
    }

}
