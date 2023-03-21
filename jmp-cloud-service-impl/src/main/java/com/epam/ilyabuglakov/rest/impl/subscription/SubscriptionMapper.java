package com.epam.ilyabuglakov.rest.impl.subscription;

import com.epam.ilyabuglakov.rest.dto.subscription.Subscription;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionRequestDto;
import com.epam.ilyabuglakov.rest.dto.subscription.SubscriptionResponseDto;
import com.epam.ilyabuglakov.rest.service.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SubscriptionMapper {

    @Autowired
    protected
    UserService userService;

    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "user", expression = "java(userService.get(subscriptionRequest.getUserId()))")
    public abstract Subscription mapToSubscription(SubscriptionRequestDto subscriptionRequest);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "startDate", source = "startDate", dateFormat = SubscriptionConfiguration.START_DATE_FORMAT)
    public abstract SubscriptionResponseDto mapToResponse(Subscription subscription);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "startDate", source = "startDate", dateFormat = SubscriptionConfiguration.START_DATE_FORMAT)
    public abstract List<SubscriptionResponseDto> mapAllToResponse(List<Subscription> subscription);
}
