package com.movieticket.movie_booking_system.service;

import com.movieticket.movie_booking_system.dto.TheatreRequest;
import com.movieticket.movie_booking_system.dto.TheatreResponse;
import java.util.List;

public interface TheatreService {
    TheatreResponse addTheatre(TheatreRequest request);

    List<TheatreResponse> getAllTheatres();

    TheatreResponse getTheatreById(Long id);

    TheatreResponse updateTheatre(Long id, TheatreRequest request);

    void deleteTheatre(Long id);
}