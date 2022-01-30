package com.adidas.publicservice.controllers;

import com.adidas.publicservice.dto.Subscription;
import com.adidas.publicservice.services.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicController {

    private final PublicService publicService;

    @Autowired
    public PublicController(PublicService producer) {
        this.publicService = producer;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> newSubscription(@RequestBody Subscription subscription) {
        return new ResponseEntity<Subscription>(this.publicService.newSubscription(subscription), HttpStatus.CREATED);
    }

    @PatchMapping("/subscriptions/{id}")
    public void cancelSubscription(@PathVariable("id") long id, @RequestBody Subscription subscription) {
        this.publicService.cancelSubscription(id);
    }

    @GetMapping("/subscriptions/{id}")
    public ResponseEntity<Subscription> getDetailsFromSubscription(@PathVariable("id") String id) {
        Subscription subscription = this.publicService.getSubscription(id);
        if (subscription != null) {
            return ResponseEntity.ok(subscription);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        return ResponseEntity.ok(this.publicService.getAllSubscriptions());
    }
}
