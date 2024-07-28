package com.example.ecomerce.user.service;

import com.example.ecomerce.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRegistrationDto dto) {
        User user = new User();
        user.setUsername(dto.getFirstName() + " " + dto.getLastName());
        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
        return user;
    }
}
