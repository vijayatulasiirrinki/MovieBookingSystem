package com.movieticket.movie_booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticket.movie_booking_system.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}