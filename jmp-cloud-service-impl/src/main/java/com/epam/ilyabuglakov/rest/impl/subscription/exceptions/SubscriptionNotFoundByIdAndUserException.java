package com.epam.ilyabuglakov.rest.impl.subscription.exceptions;

import lombok.Getter;

@Getter
public class SubscriptionNotFoundByIdAndUserException extends RuntimeException {
    private final long id;
    private final long userId;

    public SubscriptionNotFoundByIdAndUserException(long id, long userId) {
        this.id = id;
        this.userId = userId;
    }
}

