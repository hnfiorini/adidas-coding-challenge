package com.adidas.subscriptionservice.controllers;

import com.adidas.subscriptionservice.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/archive")
public class SubscriptionController {

    private final SubscriptionService producer;

    @Autowired
    public SubscriptionController(SubscriptionService producer) {
        this.producer = producer;
    }

    @GetMapping
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

}
