package com.epam.ilyabuglakov.rest.impl.user;

import com.epam.ilyabuglakov.rest.dto.user.AllUsersResponseDto;
import com.epam.ilyabuglakov.rest.dto.user.User;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import com.epam.ilyabuglakov.rest.impl.user.exceptions.UserNotFoundByIdException;
import com.epam.ilyabuglakov.rest.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequest) {
        User user = userMapper.mapToUser(userRequest);
        return userMapper.mapToResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequest) {
        verifyUserExists(userRequest.getId());
        User user = userMapper.mapToUser(userRequest);
        return userMapper.mapToResponse(userRepository.save(user));
    }

    @Override
    public void delete(long id) {
        verifyUserExists(id);
        userRepository.delete(id);
    }

    @Override
    public UserResponseDto get(long id) {
        verifyUserExists(id);
        return userMapper.mapToResponse(userRepository.findById(id));
    }

    @Override
    public AllUsersResponseDto getAll() {
        return new AllUsersResponseDto(userMapper.mapAllToResponse(userRepository.findAll()));
    }

    private void verifyUserExists(long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundByIdException(id);
        }
    }
}
