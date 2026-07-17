package com.movieticket.movie_booking_system.service.impl;

import com.movieticket.movie_booking_system.dto.BookingRequest;
import com.movieticket.movie_booking_system.dto.BookingResponse;
import com.movieticket.movie_booking_system.entity.Booking;
import com.movieticket.movie_booking_system.entity.Seat;
import com.movieticket.movie_booking_system.entity.Show;
import com.movieticket.movie_booking_system.entity.User;
import com.movieticket.movie_booking_system.repository.BookingRepository;
import com.movieticket.movie_booking_system.repository.SeatRepository;
import com.movieticket.movie_booking_system.repository.ShowRepository;
import com.movieticket.movie_booking_system.repository.UserRepository;
import com.movieticket.movie_booking_system.service.BookingService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    // Constructor
    public BookingServiceImpl(BookingRepository bookingRepository,
            UserRepository userRepository,
            ShowRepository showRepository,
            SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public BookingResponse bookTicket(BookingRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Show show = showRepository.findById(request.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));
        Seat seat = seatRepository.findById(request.getSeatId())
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        if ("BOOKED".equalsIgnoreCase(seat.getStatus())) {
            throw new RuntimeException("Seat already booked");
        }
        seat.setStatus("BOOKED");
        seatRepository.save(seat);
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setSeat(seat);
        booking.setTotalAmount(seat.getPrice());
        booking.setBookingStatus("CONFIRMED");
        booking.setBookingTime(LocalDateTime.now());
        Booking savedBooking = bookingRepository.save(booking);
        return mapToResponse(savedBooking);
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToResponse(booking);
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setBookingStatus("CANCELLED");
        Seat seat = booking.getSeat();
        seat.setStatus("AVAILABLE");
        seatRepository.save(seat);
        bookingRepository.save(booking);
    }

    private BookingResponse mapToResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setBookingId(booking.getId());
        response.setUserName(booking.getUser().getFullName());
        response.setMovieName(booking.getShow().getMovie().getMovieName());
        response.setTheatreName(booking.getShow().getTheatre().getTheatreName());
        response.setSeatNumber(booking.getSeat().getSeatNumber());
        response.setTotalAmount(booking.getTotalAmount());
        response.setBookingStatus(booking.getBookingStatus());
        response.setBookingTime(booking.getBookingTime());
        return response;
    }
}