package com.movieticket.movie_booking_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movieticket.movie_booking_system.dto.LoginRequest;
import com.movieticket.movie_booking_system.dto.LoginResponse;
import com.movieticket.movie_booking_system.dto.UserRequest;
import com.movieticket.movie_booking_system.dto.UserResponse;
import com.movieticket.movie_booking_system.entity.User;
import com.movieticket.movie_booking_system.repository.UserRepository;
import com.movieticket.movie_booking_system.service.UserService;
import com.movieticket.movie_booking_system.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserResponse registerUser(UserRequest request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        User savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getEmail(),
                savedUser.getRole(),
                "User registered successfully");

    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponse(
                "Login Successful",
                token);
    }
}
