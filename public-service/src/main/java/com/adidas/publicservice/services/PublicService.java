package com.adidas.publicservice.services;

import com.adidas.publicservice.dto.Subscription;
import com.adidas.publicservice.enums.GenderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PublicService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private String url = "http://gateway-service/subscriptions";

    public Subscription newSubscription(Subscription subscription) {
        log.info("Creating new subscription");
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        return circuitBreaker.run(() -> restTemplate.postForObject(url, subscription, Subscription.class), throwable -> getDefaultSubscription());
    }

    //THIS IS ONLY AN EXAMPLE
    private Subscription getDefaultSubscription() {
        return Subscription.builder()
                .consent(true)
                .dateOfBirth(LocalDate.of(1983, 5, 16))
                .email("this is an example of circuit breaker")
                .firstName("Nicolas")
                .gender(GenderEnum.MALE)
                .idNewsletter("1")
                .build();
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
