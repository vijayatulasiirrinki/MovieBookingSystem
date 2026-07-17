package com.movieticket.movie_booking_system.service.impl;

import com.movieticket.movie_booking_system.dto.SeatRequest;
import com.movieticket.movie_booking_system.dto.SeatResponse;
import com.movieticket.movie_booking_system.entity.Seat;
import com.movieticket.movie_booking_system.entity.Show;
import com.movieticket.movie_booking_system.repository.SeatRepository;
import com.movieticket.movie_booking_system.repository.ShowRepository;
import com.movieticket.movie_booking_system.service.SeatService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {
        private final SeatRepository seatRepository;
        private final ShowRepository showRepository;

        public SeatServiceImpl(SeatRepository seatRepository,
                        ShowRepository showRepository) {
                this.seatRepository = seatRepository;
                this.showRepository = showRepository;
        }

        @Override
        public SeatResponse addSeat(SeatRequest request) {
                Show show = showRepository.findById(request.getShowId())
                                .orElseThrow(() -> new RuntimeException("Show not found"));
                Seat seat = new Seat();
                seat.setShow(show);
                seat.setSeatNumber(request.getSeatNumber());
                seat.setSeatType(request.getSeatType());
                seat.setPrice(request.getPrice());
                seat.setStatus(request.getStatus());
                Seat savedSeat = seatRepository.save(seat);
                return new SeatResponse(
                                savedSeat.getId(),
                                savedSeat.getShow().getMovie().getMovieName(),
                                savedSeat.getShow().getTheatre().getTheatreName(),
                                savedSeat.getSeatNumber(),
                                savedSeat.getSeatType(),
                                savedSeat.getPrice(),
                                savedSeat.getStatus());
        }

        @Override
        public List<SeatResponse> getAllSeats() {
                return seatRepository.findAll()
                                .stream()
                                .map(seat -> new SeatResponse(
                                                seat.getId(),
                                                seat.getShow().getMovie().getMovieName(),
                                                seat.getShow().getTheatre().getTheatreName(),
                                                seat.getSeatNumber(),
                                                seat.getSeatType(),
                                                seat.getPrice(),
                                                seat.getStatus()))
                                .collect(Collectors.toList());
        }

        @Override
        public SeatResponse getSeatById(Long id) {
                Seat seat = seatRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Seat not found"));
                return new SeatResponse(
                                seat.getId(),
                                seat.getShow().getMovie().getMovieName(),
                                seat.getShow().getTheatre().getTheatreName(),
                                seat.getSeatNumber(),
                                seat.getSeatType(),
                                seat.getPrice(),
                                seat.getStatus());
        }

        @Override
        public SeatResponse updateSeat(Long id, SeatRequest request) {
                Seat seat = seatRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Seat not found"));
                Show show = showRepository.findById(request.getShowId())
                                .orElseThrow(() -> new RuntimeException("Show not found"));
                seat.setShow(show);
                seat.setSeatNumber(request.getSeatNumber());
                seat.setSeatType(request.getSeatType());
                seat.setPrice(request.getPrice());
                seat.setStatus(request.getStatus());
                Seat updatedSeat = seatRepository.save(seat);
                return new SeatResponse(
                                updatedSeat.getId(),
                                updatedSeat.getShow().getMovie().getMovieName(),
                                updatedSeat.getShow().getTheatre().getTheatreName(),
                                updatedSeat.getSeatNumber(),
                                updatedSeat.getSeatType(),
                                updatedSeat.getPrice(),
                                updatedSeat.getStatus());
        }

        @Override
        public void deleteSeat(Long id) {
                Seat seat = seatRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Seat not found"));
                seatRepository.delete(seat);
        }
}