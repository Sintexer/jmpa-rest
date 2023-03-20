package com.epam.ilyabuglakov.rest.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users/{userId}/subscriptions")
public interface ServiceController {

    @PostMapping
    SubscriptionResponseDto create(@PathVariable(name = "userId") long userId,
                                   SubscriptionRequestDto subscriptionRequest);

    @PutMapping("/{id}")
    SubscriptionResponseDto update(@PathVariable(name = "userId") long userId,
                                   @PathVariable(name = "id") long subscriptionId);

    @DeleteMapping("/{id}")
    ResponseEntity<Object> delete(@PathVariable(name = "userId") long userId,
                                  @PathVariable(name = "id") long subscriptionId);

    @GetMapping("/{id}")
    SubscriptionResponseDto get(@PathVariable(name = "userId") long userId,
                                @PathVariable(name = "id") long subscriptionId);

    @GetMapping
    SubscriptionResponseDto getAll();
}
