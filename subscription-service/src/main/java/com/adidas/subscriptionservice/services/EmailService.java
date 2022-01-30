package com.adidas.subscriptionservice.services;

import com.adidas.subscriptionservice.dto.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@EnableBinding(Source.class)
public class EmailService {

    @Autowired
    private Source source;

    public void sendEmail(Subscription subscription) {
        log.info(String.format("$$ -> Producing message --> %s", subscription));
        source.output().send(MessageBuilder.withPayload(subscription).build());
    }

}
