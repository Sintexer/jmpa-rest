package com.epam.ilyabuglakov.rest.impl.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.AllSubscriptionsResponseDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;
import com.epam.ilyabuglakov.rest.impl.subscription.exceptions.SubscriptionNotFoundByIdAndUserException;
import com.epam.ilyabuglakov.rest.service.subscription.SubscriptionService;
import com.epam.ilyabuglakov.rest.subscription.ServiceController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/{userId}/subscriptions")
public class ServiceControllerImpl implements ServiceController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;

    public ServiceControllerImpl(SubscriptionService subscriptionService, SubscriptionMapper subscriptionMapper) {
        this.subscriptionService = subscriptionService;
        this.subscriptionMapper = subscriptionMapper;
    }

    @PostMapping
    @Override
    public SubscriptionResponseDto create(@PathVariable(name = "userId") long userId, SubscriptionRequestDto subscriptionRequest) {
        subscriptionRequest.setUserId(userId);
        return subscriptionMapper.mapToResponse(subscriptionService.create(subscriptionRequest));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable(name = "userId") long userId,
                                         @PathVariable(name = "id") long subscriptionId) {
        subscriptionService.delete(new SubscriptionRequestDto(subscriptionId, userId));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Override
    public SubscriptionResponseDto get(@PathVariable(name = "userId") long userId,
                                       @PathVariable(name = "id") long subscriptionId) {
        return subscriptionMapper.mapToResponse(subscriptionService.get(new SubscriptionRequestDto(subscriptionId, userId)));
    }

    @GetMapping
    @Override
    public AllSubscriptionsResponseDto getAll() {
        return new AllSubscriptionsResponseDto(subscriptionMapper.mapAllToResponse(subscriptionService.getAll()));
    }

    @ExceptionHandler(SubscriptionNotFoundByIdAndUserException.class)
    public ResponseEntity<Object> handleSubscriptionNotFound(SubscriptionNotFoundByIdAndUserException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subscription with id=" + e.getId() + " and userId=" +
                e.getUserId() + " was not found");
    }
}
