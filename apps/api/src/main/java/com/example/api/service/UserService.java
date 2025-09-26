package com.example.api.service;

import com.example.api.entities.User;

public interface UserService {

    public User save(User user);
    public User findByIdOrThrow(String id);
    public User findByUsername(String username);
    public User findByEmailOrThrow(String email);
    public User findByUsernameAndPassword(String username, String password);
    public User findByEmailAndPassword(String email, String password);
    public User findByUsernameOrEmail(String username, String email);
}
