package com.adidas.subscriptionservice.services;

import com.adidas.subscriptionservice.dto.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(Source.class)
public class SubscriptionService {

    @Autowired
    private Source source;

    public void sendMessage(String message) {
        log.info(String.format("$$ -> Producing message --> %s", message));

        Subscription messageObj = new Subscription(message);

        source.output().send(MessageBuilder.withPayload(messageObj).build());
    }
}

