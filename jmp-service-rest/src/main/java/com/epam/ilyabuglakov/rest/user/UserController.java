package com.epam.ilyabuglakov.rest.user;

import com.epam.ilyabuglakov.rest.dto.user.AllUsersResponseDto;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


public interface UserController {

    UserResponseDto create(UserRequestDto userRequest);

    UserResponseDto update(long userId, UserRequestDto userRequest);

    ResponseEntity<Object> delete(long userId);

    UserResponseDto get(long userId);

    AllUsersResponseDto getAll();
}
