package com.movieticket.movie_booking_system.service;

import com.movieticket.movie_booking_system.dto.MovieRequest;
import com.movieticket.movie_booking_system.dto.MovieResponse;
import java.util.List;

public interface MovieService {
    MovieResponse addMovie(MovieRequest request);

    List<MovieResponse> getAllMovies();

    MovieResponse getMovieById(Long id);

    MovieResponse updateMovie(Long id, MovieRequest request);

    void deleteMovie(Long id);
}