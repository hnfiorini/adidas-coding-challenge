package com.adidas.subscriptionservice.controllers;

import com.adidas.subscriptionservice.dto.Subscription;
import com.adidas.subscriptionservice.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService producer) {
        this.subscriptionService = producer;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Long> newSubscription(@RequestBody Subscription subscription) {
        return new ResponseEntity<Long>(this.subscriptionService.newSubscription(subscription).getIdSubscription(),
                HttpStatus.CREATED);
    }

    @PatchMapping("/subscriptions/{id}")
    public void cancelSubscription(@PathVariable("id") long id, @RequestBody Subscription subscription) {
        this.subscriptionService.cancelSubscription(id);
    }

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> getDetailsFromSubscription(@PathVariable("id") String id) {
        Subscription subscription = this.subscriptionService.getSubscription(id);
        if (subscription != null) {
            return ResponseEntity.ok(subscription);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        return ResponseEntity.ok(this.subscriptionService.getAllSubscriptions());
    }

}