package com.movieticket.movie_booking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.movie_booking_system.dto.LoginRequest;
import com.movieticket.movie_booking_system.dto.LoginResponse;
import com.movieticket.movie_booking_system.dto.UserRequest;
import com.movieticket.movie_booking_system.dto.UserResponse;
import com.movieticket.movie_booking_system.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("/profile")
    public String profile() {
        return "Welcome! You are authenticated.";
    }
}