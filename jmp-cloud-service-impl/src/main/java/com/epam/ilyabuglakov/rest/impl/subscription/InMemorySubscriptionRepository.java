package com.epam.ilyabuglakov.rest.impl.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.Subscription;
import com.epam.ilyabuglakov.rest.dto.user.User;
import com.epam.ilyabuglakov.rest.impl.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemorySubscriptionRepository implements SubscriptionRepository {

    private final AtomicLong idGenerator = new AtomicLong();
    private final Map<Long, Subscription> subscriptions = new HashMap<>();

    @Override
    public List<Subscription> findAll() {
        return subscriptions.values().stream().toList();
    }

    @Override
    public Subscription findByIdAndUserId(long id, long userId) {
        Subscription subscription = subscriptions.get(id);
        if (subscription == null || subscription.getUser().getId() != userId) {
            return null;
        }
        return subscription;
    }

    @Override
    public boolean existsById(long id, long userId) {
        return subscriptions.containsKey(id) && subscriptions.get(id).getId() == userId;
    }

    @Override
    public Subscription save(Subscription subscription) {
        if (subscription.getId() == null) {
            subscription.setId(idGenerator.incrementAndGet());
        }
        subscriptions.put(subscription.getId(), subscription);
        return subscription;
    }

    @Override
    public void delete(long id) {
        subscriptions.remove(id);
    }
}
