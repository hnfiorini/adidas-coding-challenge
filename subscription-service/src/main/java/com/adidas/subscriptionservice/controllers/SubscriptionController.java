package com.adidas.subscriptionservice.controllers;

import com.adidas.subscriptionservice.dto.Subscription;
import com.adidas.subscriptionservice.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        //this.producer.sendMessage(message);
    }




    @PostMapping
    public ResponseEntity<Subscription> newSubscription(@RequestBody Subscription subscription){
        return ResponseEntity.ok(this.producer.newSubscription(subscription));
    }

    @PatchMapping
    public void cancelSubscription(@RequestParam("message") String message){
    }

    @GetMapping
    public void getDetailsFromSubscription(@RequestParam("message") String message){
    }

    @GetMapping
    public void getAllSubscriptions(@RequestParam("message") String message){
    }

}