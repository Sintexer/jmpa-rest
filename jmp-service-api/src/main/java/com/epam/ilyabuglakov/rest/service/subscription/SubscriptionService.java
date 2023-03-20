package com.epam.ilyabuglakov.rest.service.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.AllSubscriptionsResponseDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;

public interface SubscriptionService {
    SubscriptionResponseDto create(SubscriptionRequestDto userRequest);
    SubscriptionResponseDto update(SubscriptionRequestDto userRequest);
    void delete(long id);
    SubscriptionResponseDto get(long id);
    AllSubscriptionsResponseDto getAll();
}
