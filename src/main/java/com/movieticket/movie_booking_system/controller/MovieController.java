package com.movieticket.movie_booking_system.controller;

import com.movieticket.movie_booking_system.dto.MovieRequest;

import com.movieticket.movie_booking_system.dto.MovieResponse;

import com.movieticket.movie_booking_system.service.MovieService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/movies")

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {

        this.movieService = movieService;

    }

    @PostMapping

    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest request) {

        return new ResponseEntity<>(movieService.addMovie(request), HttpStatus.CREATED);

    }

    @GetMapping

    public ResponseEntity<List<MovieResponse>> getAllMovies() {

        return ResponseEntity.ok(movieService.getAllMovies());

    }

    @GetMapping("/{id}")

    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {

        return ResponseEntity.ok(movieService.getMovieById(id));

    }

    @PutMapping("/{id}")

    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id,

            @RequestBody MovieRequest request) {

        return ResponseEntity.ok(movieService.updateMovie(id, request));

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return ResponseEntity.ok("Movie deleted successfully");

    }

}
