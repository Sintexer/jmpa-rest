package com.epam.ilyabuglakov.rest.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String birthday;
}
