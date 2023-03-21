package com.epam.ilyabuglakov.rest.impl.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.Subscription;

import java.util.List;

public interface SubscriptionRepository {
    List<Subscription> findAll();

    Subscription findByIdAndUserId(long id, long userId);

    boolean existsById(long id, long userId);

    Subscription save(Subscription subscription);

    void delete(long id);
}
