package com.example.ecomerce.user.service;

import com.example.ecomerce.user.domain.User;
import com.example.ecomerce.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private User user;
    private UserRegistrationDto userRegistrationDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setUsername("Test Name");
        user.setEmail("test@example.com");
//        user.setPassword("password");

        userRegistrationDTO = new UserRegistrationDto();
        userRegistrationDTO.setFirstName("Test");
        userRegistrationDTO.setLastName("User");
        userRegistrationDTO.setEmail("test@example.com");
//        userRegistrationDTO.setPassword("password");
    }

    @Test
    public void testRegisterUser() {
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(userMapper.toEntity(any(UserRegistrationDto.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User registeredUser = userService.registerUser(userRegistrationDTO);

        assertEquals("Test Name", registeredUser.getUsername());
    }

    @Test
    public void testRegisterUser_EmailAlreadyExists() {
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.registerUser(userRegistrationDTO);
        });

        assertEquals("User with email test@example.com already exists.", exception.getMessage());
    }
}
