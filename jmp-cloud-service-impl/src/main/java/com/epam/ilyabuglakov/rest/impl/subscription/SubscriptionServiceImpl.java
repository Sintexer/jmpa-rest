package com.epam.ilyabuglakov.rest.impl.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.Subscription;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.impl.subscription.exceptions.SubscriptionNotFoundByIdAndUserException;
import com.epam.ilyabuglakov.rest.service.subscription.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @Override
    public Subscription create(SubscriptionRequestDto subscriptionRequest) {
        Subscription subscription = subscriptionMapper.mapToSubscription(subscriptionRequest);
        subscription.setId(null);
        subscription.setStartDate(LocalDate.now());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(SubscriptionRequestDto subscriptionRequestDto) {
        verifySubscriptionExists(subscriptionRequestDto.getId(), subscriptionRequestDto.getUserId());
        subscriptionRepository.delete(subscriptionRequestDto.getId());
    }

    @Override
    public Subscription get(SubscriptionRequestDto subscriptionRequestDto) {
        verifySubscriptionExists(subscriptionRequestDto.getId(), subscriptionRequestDto.getUserId());
        Subscription subscription = subscriptionRepository.findByIdAndUserId(subscriptionRequestDto.getId(), subscriptionRequestDto.getUserId());
        if (subscription == null) {
            throw new SubscriptionNotFoundByIdAndUserException(subscriptionRequestDto.getId(), subscriptionRequestDto.getUserId());
        }
        return subscription;
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    private void verifySubscriptionExists(long id, long userId) {
        if (subscriptionRepository.existsById(id, userId)) {
            throw new SubscriptionNotFoundByIdAndUserException(id, userId);
        }
    }
}
