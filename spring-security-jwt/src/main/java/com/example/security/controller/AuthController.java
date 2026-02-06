package com.example.security.controller;

import com.example.security.entity.User;
import com.example.security.service.UserService;
import com.example.security.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {

        userService.register(username, password);
        return "User registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        User user = userService.findByUsername(username);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return JwtUtil.generateToken(username);
    }

    // LOGOUT
    @PostMapping("/logout")
    public String logout() {
        return "Logout successful. Please delete token on client side.";
    }
}
