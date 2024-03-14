package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.CreateUserRequest;
import com.example.authorbookrest.dto.UserDto;
import com.example.authorbookrest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);

    @Mapping(target = "UserType", constant = "USER")
    User map(CreateUserRequest createUserRequest);
}
