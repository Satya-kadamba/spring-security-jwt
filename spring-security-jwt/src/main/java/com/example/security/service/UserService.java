package com.example.security.service;

import com.example.security.entity.User;

public interface UserService {

    User register(String username, String password);

    User findByUsername(String username);
}
