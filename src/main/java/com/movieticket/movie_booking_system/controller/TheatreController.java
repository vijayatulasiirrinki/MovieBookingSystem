package com.movieticket.movie_booking_system.controller;

import com.movieticket.movie_booking_system.dto.TheatreRequest;
import com.movieticket.movie_booking_system.dto.TheatreResponse;
import com.movieticket.movie_booking_system.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public ResponseEntity<TheatreResponse> addTheatre(@RequestBody TheatreRequest request) {
        return new ResponseEntity<>(theatreService.addTheatre(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TheatreResponse>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreResponse> getTheatreById(@PathVariable Long id) {
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheatreResponse> updateTheatre(@PathVariable Long id,
            @RequestBody TheatreRequest request) {
        return ResponseEntity.ok(theatreService.updateTheatre(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok("Theatre deleted successfully");
    }
}