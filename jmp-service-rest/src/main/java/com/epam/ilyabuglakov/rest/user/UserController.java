package com.epam.ilyabuglakov.rest.user;

import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserController {

    UserResponseDto create(UserRequestDto userRequest);

    UserResponseDto update(UserRequestDto userRequest);

    ResponseEntity<Object> delete(long id);

    UserResponseDto get(long id);

    UserResponseDto getAll(long id);
}
