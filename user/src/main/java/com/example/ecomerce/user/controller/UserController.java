package com.example.ecomerce.user.controller;


import com.example.ecomerce.user.domain.User;
import com.example.ecomerce.user.service.UserRegistrationDto;
import com.example.ecomerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto userRegistrationDTO) {
        User registeredUser = userService.registerUser(userRegistrationDTO);
        return ResponseEntity.ok(registeredUser);
    }
}
