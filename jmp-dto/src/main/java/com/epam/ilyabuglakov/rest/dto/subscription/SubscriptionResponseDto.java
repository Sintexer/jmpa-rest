package com.epam.ilyabuglakov.rest.dto.subscription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionResponseDto {
    private Long id;
    private Long userId;
    private String startDate;
}
