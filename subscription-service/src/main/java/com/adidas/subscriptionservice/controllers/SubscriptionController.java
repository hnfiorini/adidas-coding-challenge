package com.adidas.subscriptionservice.controllers;

import com.adidas.subscriptionservice.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/archive")
public class SubscriptionController {

    private final SubscriptionService producer;

    @Autowired
    public SubscriptionController(SubscriptionService producer) {
        this.producer = producer;
    }

    @GetMapping
    public void sendMessage(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @PostMapping
    public void newSubscription(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @PatchMapping
    public void cancelSubscription(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @GetMapping
    public void getDetailsFromSubscription(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

    @GetMapping
    public void getAllSubscriptions(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }

}