package com.adidas.subscriptionservice.mappers;

import com.adidas.subscriptionservice.dto.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;

public class SubscriptionMapper {

    public static SubscriptionEntity dtoToEntity(Subscription model) {
        return SubscriptionEntity.builder()
                .consent(model.getConsent())
                .dayOfBirth(model.getDayOfBirth())
                .firstName(model.getFirstName())
                .email(model.getEmail())
                .gender(model.getGender())
                .idNewsletter(model.getIdNewsletter())
                .build();
    }

    public static Subscription entityToDto(SubscriptionEntity entity) {
        return Subscription.builder()
                .consent(entity.isConsent())
                .dayOfBirth(entity.getDayOfBirth())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .gender(entity.getGender())
                .idNewsletter(entity.getIdNewsletter())
                .build();
    }
}
