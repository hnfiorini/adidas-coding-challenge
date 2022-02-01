package com.adidas.publicservice.services;

import com.adidas.publicservice.dto.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class PublicService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private String url = "http://gateway-service/subscriptions";

    public Long newSubscription(Subscription subscription) {
        log.info("Creating new subscription");
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        //return circuitBreaker.run(() -> restTemplate.postForObject(url, subscription, Long.class), throwable -> getDefaultIdSubscription(throwable));
        return restTemplate.postForObject(url, subscription, Long.class);
    }

    //THIS IS ONLY AN EXAMPLE
    private Long getDefaultIdSubscription(Throwable throwable) {
        log.info("Default subscription: " + throwable.getMessage());
        return 0L;
    }

    public void cancelSubscription(long id) {
        Subscription subscription = getSubscription(String.valueOf(id));
        restTemplate.patchForObject(url + "/" + id, subscription, Subscription.class);
    }

    public Subscription getSubscription(String id) {
        return restTemplate.getForObject(url + "/" + id, Subscription.class);
    }

    public List<Subscription> getAllSubscriptions() {
        return restTemplate.getForObject(url, List.class);
    }
}
