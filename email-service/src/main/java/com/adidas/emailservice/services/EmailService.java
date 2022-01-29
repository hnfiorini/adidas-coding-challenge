package com.adidas.emailservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @KafkaListener(topics = "subscription")
    public void consume(String message){
        log.info(String.format("$$ -> Consumed Message -> %s", message));
    }
}
