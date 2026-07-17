package com.movieticket.movie_booking_system.service;

import com.movieticket.movie_booking_system.dto.LoginRequest;
import com.movieticket.movie_booking_system.dto.LoginResponse;
import com.movieticket.movie_booking_system.dto.UserRequest;
import com.movieticket.movie_booking_system.dto.UserResponse;
//import com.movieticket.movie_booking_system.entity.User;

public interface UserService {
    UserResponse registerUser(UserRequest request);

    LoginResponse login(LoginRequest request);
}