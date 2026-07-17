package com.movieticket.movie_booking_system.service;

import com.movieticket.movie_booking_system.dto.ShowRequest;
import com.movieticket.movie_booking_system.dto.ShowResponse;
import java.util.List;

public interface ShowService {
    ShowResponse addShow(ShowRequest request);

    List<ShowResponse> getAllShows();

    ShowResponse getShowById(Long id);

    ShowResponse updateShow(Long id, ShowRequest request);

    void deleteShow(Long id);
}