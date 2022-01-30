package com.adidas.subscriptionservice.services;

import com.adidas.subscriptionservice.dto.Subscription;
import com.adidas.subscriptionservice.mappers.SubscriptionMapper;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import com.adidas.subscriptionservice.repositories.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private EmailService emailService;

    public Subscription newSubscription(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = SubscriptionMapper.dtoToEntity(subscription);
        subscriptionEntity.setActive(true);
        SubscriptionEntity entity = subscriptionRepository.save(subscriptionEntity);
        emailService.sendEmail(subscription);
        return SubscriptionMapper.entityToDto(entity);
    }

    public Iterable<SubscriptionEntity> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscription(String id) {
        Optional<SubscriptionEntity> entityOp = subscriptionRepository.findById(Long.getLong(id));
        return entityOp.map(SubscriptionMapper::entityToDto).orElse(null);
    }

    @Transactional
    public void cancelSubscription(long subscription) {
        Optional<SubscriptionEntity> entity = subscriptionRepository.findById(subscription);
        if (entity.isPresent()) {
            entity.get().setActive(false);
        }
    }
}

