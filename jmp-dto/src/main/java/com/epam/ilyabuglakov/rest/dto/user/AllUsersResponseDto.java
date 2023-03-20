package com.epam.ilyabuglakov.rest.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllUsersResponseDto {
    private List<UserResponseDto> users;
}
