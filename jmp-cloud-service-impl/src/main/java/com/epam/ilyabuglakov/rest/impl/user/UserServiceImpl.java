package com.epam.ilyabuglakov.rest.impl.user;

import com.epam.ilyabuglakov.rest.dto.user.User;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.impl.user.exceptions.UserNotFoundByIdException;
import com.epam.ilyabuglakov.rest.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserRequestDto userRequest) {
        User user = userMapper.mapToUser(userRequest);
        user.setId(null);
        return userRepository.save(user);
    }

    @Override
    public User update(UserRequestDto userRequest) {
        verifyUserExists(userRequest.getId());
        User user = userMapper.mapToUser(userRequest);
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        verifyUserExists(id);
        userRepository.delete(id);
    }

    @Override
    public User get(long id) {
        verifyUserExists(id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    private void verifyUserExists(long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundByIdException(id);
        }
    }
}
