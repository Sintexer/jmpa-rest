package com.epam.ilyabuglakov.rest.dto.subscription;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllSubscriptionsResponseDto {
    private List<SubscriptionResponseDto> subscriptions;
}
