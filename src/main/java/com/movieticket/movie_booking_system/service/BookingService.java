package com.movieticket.movie_booking_system.service;

import com.movieticket.movie_booking_system.dto.BookingRequest;
import com.movieticket.movie_booking_system.dto.BookingResponse;
import java.util.List;

public interface BookingService {
    BookingResponse bookTicket(BookingRequest request);

    List<BookingResponse> getAllBookings();

    BookingResponse getBookingById(Long id);

    void cancelBooking(Long id);
}