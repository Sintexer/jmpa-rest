package com.epam.ilyabuglakov.rest.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;

public class SubscriptionController {

    public SubscriptionResponseDto create(SubscriptionRequestDto subscriptionRequest) {
        return null;
    }

    public SubscriptionResponseDto update(SubscriptionRequestDto subscriptionRequest) {
        return null;
    }

    public ResponseEntity<Object> delete(long id) {
        return ResponseEntity.internalServerError().build();
    }

    public SubscriptionResponseDto get(long id) {
        return null;
    }

    public SubscriptionResponseDto getAll() {
        return null;
    }
}
