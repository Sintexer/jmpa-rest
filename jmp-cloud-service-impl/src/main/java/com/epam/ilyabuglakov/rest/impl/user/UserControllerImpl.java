package com.epam.ilyabuglakov.rest.impl.user;

import com.epam.ilyabuglakov.rest.dto.user.AllUsersResponseDto;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import com.epam.ilyabuglakov.rest.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeParseException;

@RequestMapping("/api/users")
@RestController
public class UserControllerImpl {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserControllerImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto userRequest) {
        return userMapper.mapToResponse(userService.create(userRequest));
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable(name = "id") long userId, @RequestBody UserRequestDto userRequest) {
        userRequest.setId(userId);
        return userMapper.mapToResponse(userService.update(userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable(name = "id") long userId) {
        return userMapper.mapToResponse(userService.get(userId));
    }

    @GetMapping
    public AllUsersResponseDto getAll() {
        return new AllUsersResponseDto(userMapper.mapAllToResponse(userService.getAll()));
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleBadRequest(DateTimeParseException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provided birthday cannot be parsed by pattern " + UserConfiguration.BIRTHDAY_DATE_FORMAT);
    }
}
