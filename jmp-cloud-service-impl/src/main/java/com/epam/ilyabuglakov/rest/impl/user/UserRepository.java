package com.epam.ilyabuglakov.rest.impl.user;

import com.epam.ilyabuglakov.rest.dto.user.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(long id);
    boolean existsById(long id);
    User save(User user);
    void delete(long id);
}
