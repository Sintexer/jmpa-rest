package com.epam.ilyabuglakov.rest.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;

public interface ServiceController {

    SubscriptionResponseDto create(SubscriptionRequestDto subscriptionRequest);

    SubscriptionResponseDto update(SubscriptionRequestDto subscriptionRequest);

    ResponseEntity<Object> delete(long id);

    SubscriptionResponseDto get(long id);

    SubscriptionResponseDto getAll();
}
