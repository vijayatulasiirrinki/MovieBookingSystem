package com.movieticket.movie_booking_system.service.impl;

import com.movieticket.movie_booking_system.dto.MovieRequest;
import com.movieticket.movie_booking_system.dto.MovieResponse;
import com.movieticket.movie_booking_system.entity.Movie;
import com.movieticket.movie_booking_system.repository.MovieRepository;
import com.movieticket.movie_booking_system.service.MovieService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieResponse addMovie(MovieRequest request) {
        Movie movie = new Movie();
        movie.setMovieName(request.getMovieName());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setLanguage(request.getLanguage());
        movie.setReleaseDate(request.getReleaseDate());
        Movie savedMovie = movieRepository.save(movie);
        return new MovieResponse(
                savedMovie.getId(),
                savedMovie.getMovieName(),
                savedMovie.getGenre(),
                savedMovie.getDuration(),
                savedMovie.getLanguage(),
                savedMovie.getReleaseDate());
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> new MovieResponse(
                        movie.getId(),
                        movie.getMovieName(),
                        movie.getGenre(),
                        movie.getDuration(),
                        movie.getLanguage(),
                        movie.getReleaseDate()))
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return new MovieResponse(
                movie.getId(),
                movie.getMovieName(),
                movie.getGenre(),
                movie.getDuration(),
                movie.getLanguage(),
                movie.getReleaseDate());
    }

    @Override
    public MovieResponse updateMovie(Long id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setMovieName(request.getMovieName());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setLanguage(request.getLanguage());
        movie.setReleaseDate(request.getReleaseDate());
        Movie updatedMovie = movieRepository.save(movie);
        return new MovieResponse(
                updatedMovie.getId(),
                updatedMovie.getMovieName(),
                updatedMovie.getGenre(),
                updatedMovie.getDuration(),
                updatedMovie.getLanguage(),
                updatedMovie.getReleaseDate());
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movieRepository.delete(movie);
    }
}