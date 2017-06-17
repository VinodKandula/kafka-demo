package com.example;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * Keys are used to determine the partition within a log to which a message get's appended to.
 * Splitting a log into partitions allows to scale-out the system.
 *
 * @author Zoltan Altfatter
 */

@Component
public class Producer {

    // Spring’s KafkaTemplate is auto-configured
    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedDelay = 1000)
    public void send() {
        kafkaTemplate.send("test", "Haliho" + new Date());
    }

}
