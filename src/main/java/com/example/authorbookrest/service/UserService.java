package com.example.authorbookrest.service;

import com.example.authorbookrest.dto.CreateUserRequest;
import com.example.authorbookrest.dto.UserDto;
import com.example.authorbookrest.entity.User;

public interface UserService {

    UserDto create(CreateUserRequest createUserRequest);
    User findByEmail(String email);
}
