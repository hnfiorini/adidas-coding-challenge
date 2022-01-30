package com.adidas.subscriptionservice.repositories;

import com.adidas.subscriptionservice.model.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Long> {
}
