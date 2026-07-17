package com.movieticket.movie_booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticket.movie_booking_system.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}