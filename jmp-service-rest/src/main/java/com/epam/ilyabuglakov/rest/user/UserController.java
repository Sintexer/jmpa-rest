package com.epam.ilyabuglakov.rest.user;

import com.epam.ilyabuglakov.rest.dto.user.User;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    public UserResponseDto create(UserRequestDto userRequest) {
        return null;
    }

    public UserResponseDto update(UserRequestDto userRequest) {
        return null;
    }

    public ResponseEntity<Object> delete(long id) {
        return ResponseEntity.internalServerError().build();
    }

    public UserResponseDto get(long id) {
        return null;
    }

    public UserResponseDto getAll(long id) {
        return null;
    }
}
