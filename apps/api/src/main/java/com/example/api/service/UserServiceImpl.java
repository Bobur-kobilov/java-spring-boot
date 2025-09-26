package com.example.api.service;

import com.example.api.repository.UserRepository;
import com.example.api.entities.User;
import org.springframework.stereotype.Service;
import com.example.api.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private RestClient restClient;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        log.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    public User findByIdOrThrow(String id) {
        log.info("Finding user by id: {}", id);
        // String response = restClient.get()
        //         .uri("https://jsonplaceholder.typicode.com/posts/1") // Specify the target URI
        //         .retrieve() // Execute the request
        //         .body(String.class);
        // log.info("Response: {}", response);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    
    public User findByUsername(String username) {
        log.info("Finding user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    public User findByEmailOrThrow(String email) {
        log.info("Finding user by email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
    
}
