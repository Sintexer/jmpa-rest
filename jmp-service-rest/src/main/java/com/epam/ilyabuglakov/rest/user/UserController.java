package com.epam.ilyabuglakov.rest.user;

import com.epam.ilyabuglakov.rest.dto.user.AllUsersResponseDto;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
public interface UserController {

    @PostMapping
    UserResponseDto create(@PathVariable(name = "id") long userId, UserRequestDto userRequest);

    @PutMapping("/{id}")
    UserResponseDto update(@PathVariable(name = "id") long userId, UserRequestDto userRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<Object> delete(@PathVariable(name = "id") long userId);

    @GetMapping("/{id}")
    UserResponseDto get(@PathVariable(name = "id") long userId);

    AllUsersResponseDto getAll();
}
