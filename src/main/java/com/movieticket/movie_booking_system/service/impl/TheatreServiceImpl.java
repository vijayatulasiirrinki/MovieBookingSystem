package com.movieticket.movie_booking_system.service.impl;

import com.movieticket.movie_booking_system.dto.TheatreRequest;
import com.movieticket.movie_booking_system.dto.TheatreResponse;
import com.movieticket.movie_booking_system.entity.Theatre;
import com.movieticket.movie_booking_system.repository.TheatreRepository;
import com.movieticket.movie_booking_system.service.TheatreService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {
    private final TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public TheatreResponse addTheatre(TheatreRequest request) {
        Theatre theatre = new Theatre();
        theatre.setTheatreName(request.getTheatreName());
        theatre.setLocation(request.getLocation());
        theatre.setCity(request.getCity());
        theatre.setTotalScreens(request.getTotalScreens());
        theatre.setContactNumber(request.getContactNumber());
        Theatre savedTheatre = theatreRepository.save(theatre);
        return new TheatreResponse(
                savedTheatre.getId(),
                savedTheatre.getTheatreName(),
                savedTheatre.getLocation(),
                savedTheatre.getCity(),
                savedTheatre.getTotalScreens(),
                savedTheatre.getContactNumber());
    }

    @Override
    public List<TheatreResponse> getAllTheatres() {
        return theatreRepository.findAll()
                .stream()
                .map(theatre -> new TheatreResponse(
                        theatre.getId(),
                        theatre.getTheatreName(),
                        theatre.getLocation(),
                        theatre.getCity(),
                        theatre.getTotalScreens(),
                        theatre.getContactNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public TheatreResponse getTheatreById(Long id) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        return new TheatreResponse(
                theatre.getId(),
                theatre.getTheatreName(),
                theatre.getLocation(),
                theatre.getCity(),
                theatre.getTotalScreens(),
                theatre.getContactNumber());
    }

    @Override
    public TheatreResponse updateTheatre(Long id, TheatreRequest request) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        theatre.setTheatreName(request.getTheatreName());
        theatre.setLocation(request.getLocation());
        theatre.setCity(request.getCity());
        theatre.setTotalScreens(request.getTotalScreens());
        theatre.setContactNumber(request.getContactNumber());
        Theatre updatedTheatre = theatreRepository.save(theatre);
        return new TheatreResponse(
                updatedTheatre.getId(),
                updatedTheatre.getTheatreName(),
                updatedTheatre.getLocation(),
                updatedTheatre.getCity(),
                updatedTheatre.getTotalScreens(),
                updatedTheatre.getContactNumber());
    }

    @Override
    public void deleteTheatre(Long id) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        theatreRepository.delete(theatre);
    }
}