package com.epam.ilyabuglakov.rest.dto.subscription;

import com.epam.ilyabuglakov.rest.dto.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private Long id;
    private User user;
    private LocalDate startDate;
}
