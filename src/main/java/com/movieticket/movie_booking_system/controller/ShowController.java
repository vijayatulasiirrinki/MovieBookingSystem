package com.movieticket.movie_booking_system.controller;

import com.movieticket.movie_booking_system.dto.ShowRequest;
import com.movieticket.movie_booking_system.dto.ShowResponse;
import com.movieticket.movie_booking_system.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public ResponseEntity<ShowResponse> addShow(@RequestBody ShowRequest request) {
        return new ResponseEntity<>(showService.addShow(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowResponse>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponse> getShowById(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowResponse> updateShow(@PathVariable Long id,
            @RequestBody ShowRequest request) {
        return ResponseEntity.ok(showService.updateShow(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.ok("Show deleted successfully");
    }
}