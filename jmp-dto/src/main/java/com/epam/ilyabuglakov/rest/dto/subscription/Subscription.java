package com.epam.ilyabuglakov.rest.dto.subscription;

import com.epam.ilyabuglakov.rest.dto.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Subscription {
    private Long id;
    private User user;
    private LocalDate startDate;
}
