package com.epam.ilyabuglakov.rest.dto.subscription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllSubscriptionsResponseDto {
    private List<SubscriptionResponseDto> subscriptions;
}
