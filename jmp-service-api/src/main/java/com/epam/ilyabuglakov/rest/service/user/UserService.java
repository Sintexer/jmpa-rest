package com.epam.ilyabuglakov.rest.service.user;

import com.epam.ilyabuglakov.rest.dto.user.AllUsersResponseDto;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto create(UserRequestDto userRequest);
    UserResponseDto update(UserRequestDto userRequest);
    void delete(long id);
    UserResponseDto get(long id);
    AllUsersResponseDto getAll();
}
