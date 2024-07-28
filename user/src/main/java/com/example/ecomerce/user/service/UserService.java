package com.example.ecomerce.user.service;

import com.example.ecomerce.user.domain.User;
import com.example.ecomerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User registerUser(UserRegistrationDto userRegistrationDTO) {
        if (userRepository.existsByEmail(userRegistrationDTO.getEmail())) {
            throw new RuntimeException("User with email " + userRegistrationDTO.getEmail() + " already exists.");
        }

        User user = userMapper.toEntity(userRegistrationDTO);
        return userRepository.save(user);
    }
}
