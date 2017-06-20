package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * @author Zoltan Altfatter
 */
@Configuration
public class ConsumerKafkaConfiguration {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> jsonKafkaListenerContainerFactory(ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }

}
