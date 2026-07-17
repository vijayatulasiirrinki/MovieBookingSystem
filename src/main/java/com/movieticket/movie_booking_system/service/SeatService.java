package com.movieticket.movie_booking_system.service;

import com.movieticket.movie_booking_system.dto.SeatRequest;
import com.movieticket.movie_booking_system.dto.SeatResponse;
import java.util.List;

public interface SeatService {
    SeatResponse addSeat(SeatRequest request);

    List<SeatResponse> getAllSeats();

    SeatResponse getSeatById(Long id);

    SeatResponse updateSeat(Long id, SeatRequest request);

    void deleteSeat(Long id);
}