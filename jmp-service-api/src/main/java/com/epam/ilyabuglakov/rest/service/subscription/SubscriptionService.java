package com.epam.ilyabuglakov.rest.service.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.Subscription;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;

import java.util.List;

public interface SubscriptionService {
    Subscription create(SubscriptionRequestDto subscriptionRequest);

    void delete(SubscriptionRequestDto subscriptionRequestDto);

    Subscription get(SubscriptionRequestDto subscriptionRequestDto);

    List<Subscription> getAll();
}
