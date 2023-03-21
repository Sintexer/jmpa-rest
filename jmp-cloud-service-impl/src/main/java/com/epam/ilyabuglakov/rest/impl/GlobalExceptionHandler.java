package com.epam.ilyabuglakov.rest.impl;

import com.epam.ilyabuglakov.rest.impl.user.exceptions.UserNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundByIdException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id=" + e.getId() + " was not found");
    }
}
