package com.epam.ilyabuglakov.rest.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.AllSubscriptionsResponseDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;

public interface ServiceController {


    SubscriptionResponseDto create(long userId,
                                   SubscriptionRequestDto subscriptionRequest);


    ResponseEntity<Object> delete(long userId,
                                  long subscriptionId);

    SubscriptionResponseDto get(long userId,
                                long subscriptionId);

    AllSubscriptionsResponseDto getAll();
}
