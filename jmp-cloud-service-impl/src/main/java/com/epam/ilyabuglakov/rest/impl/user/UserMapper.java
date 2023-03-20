package com.epam.ilyabuglakov.rest.impl.user;

import com.epam.ilyabuglakov.rest.dto.user.User;
import com.epam.ilyabuglakov.rest.dto.user.UserRequestDto;
import com.epam.ilyabuglakov.rest.dto.user.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="birthday", source = "birthday", dateFormat = UserConfiguration.BIRTHDAY_DATE_FORMAT)
    User mapToUser(UserRequestDto userRequestDto);

    @Mapping(target="birthday", source = "birthday", dateFormat = UserConfiguration.BIRTHDAY_DATE_FORMAT)
    UserResponseDto mapToResponse(User user);

    @Mapping(target="birthday", source = "birthday", dateFormat = UserConfiguration.BIRTHDAY_DATE_FORMAT)
    List<UserResponseDto> mapAllToResponse(List<User> user);
}
