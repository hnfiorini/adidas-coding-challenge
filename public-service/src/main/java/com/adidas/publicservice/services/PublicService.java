package com.adidas.publicservice.services;

import com.adidas.publicservice.dto.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PublicService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://gateway-service/subscriptions";

    public Subscription newSubscription(Subscription subscription) {
        return restTemplate.postForObject(url, subscription, Subscription.class);
    }

    public void cancelSubscription(long id) {
    }

    public Subscription getSubscription(String id) {
        return restTemplate.getForObject(url + "/" + id, Subscription.class);
    }

    public List<Subscription> getAllSubscriptions() {
        return restTemplate.getForObject(url, List.class);
    }
}
