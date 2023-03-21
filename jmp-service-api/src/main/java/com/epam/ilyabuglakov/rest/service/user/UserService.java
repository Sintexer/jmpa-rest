package com.epam.ilyabuglakov.rest.service.user;

import com.epam.ilyabuglakov.rest.dto.user.User;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;

import java.util.List;

public interface UserService {
    User create(UserRequestDto userRequest);
    User update(UserRequestDto userRequest);
    void delete(long id);
    User get(long id);
    List<User> getAll();
}
