package com.adidas.subscriptionservice.services;

import com.adidas.subscriptionservice.dto.Subscription;
import com.adidas.subscriptionservice.mappers.SubscriptionMapper;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import com.adidas.subscriptionservice.repositories.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription newSubscription(Subscription subscription) {
        SubscriptionEntity entity = subscriptionRepository.save(SubscriptionMapper.dtoToEntity(subscription));
        return SubscriptionMapper.entityToDto(entity);
    }
}

