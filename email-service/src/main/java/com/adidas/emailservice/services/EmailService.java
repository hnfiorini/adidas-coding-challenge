package com.adidas.emailservice.services;

import com.adidas.emailservice.dto.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class EmailService {

    @StreamListener(Sink.INPUT)
    public void consume(Subscription message){
        log.info(String.format("$$ -> Consumed Message -> %s", message));
    }

}
