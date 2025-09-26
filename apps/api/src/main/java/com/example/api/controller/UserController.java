package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.api.service.UserService;
import com.example.api.entities.User;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return this.userService.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id) {
        return this.userService.findByIdOrThrow(id);
    }

    @GetMapping("/user/email/{email}")
    public User getEmail(@PathVariable("email") String email) {
        return this.userService.findByEmailOrThrow(email);
    }
}


