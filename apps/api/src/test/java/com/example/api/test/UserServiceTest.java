package com.example.api.test;

import com.example.api.service.UserService;
import com.example.api.service.UserServiceImpl;
import com.example.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.example.api.entities.User;
import java.util.Optional;

class UserServiceTest {
    
    private UserService userService;
    
    @Mock
    private UserRepository userRepository;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }
    
    @Test
    void findByIdOrThrow() {
        // Arrange
        String id = "1";
        User expectedUser = new User(id, "John Doe", "john.doe@example.com", "password");
        
        // Mock UserRepository behavior
        when(userRepository.findById(id)).thenReturn(Optional.of(expectedUser));
        
        // Act
        User result = userService.findByIdOrThrow(id);
        
        // Assert
        assertEquals(expectedUser, result);
    }
}
