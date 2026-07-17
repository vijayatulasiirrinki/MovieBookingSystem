package com.movieticket.movie_booking_system.service.impl;

import com.movieticket.movie_booking_system.dto.ShowRequest;
import com.movieticket.movie_booking_system.dto.ShowResponse;
import com.movieticket.movie_booking_system.entity.Movie;
import com.movieticket.movie_booking_system.entity.Show;
import com.movieticket.movie_booking_system.entity.Theatre;
import com.movieticket.movie_booking_system.repository.MovieRepository;
import com.movieticket.movie_booking_system.repository.ShowRepository;
import com.movieticket.movie_booking_system.repository.TheatreRepository;
import com.movieticket.movie_booking_system.service.ShowService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;

    public ShowServiceImpl(ShowRepository showRepository,
            MovieRepository movieRepository,
            TheatreRepository theatreRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    @Override
    public ShowResponse addShow(ShowRequest request) {
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        Theatre theatre = theatreRepository.findById(request.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        Show show = new Show();
        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setScreenNumber(request.getScreenNumber());
        show.setShowDate(request.getShowDate());
        show.setShowTime(request.getShowTime());
        show.setTicketPrice(request.getTicketPrice());
        show.setAvailableSeats(request.getAvailableSeats());
        Show savedShow = showRepository.save(show);
        return new ShowResponse(
                savedShow.getId(),
                savedShow.getMovie().getMovieName(),
                savedShow.getTheatre().getTheatreName(),
                savedShow.getScreenNumber(),
                savedShow.getShowDate(),
                savedShow.getShowTime(),
                savedShow.getTicketPrice(),
                savedShow.getAvailableSeats());
    }

    @Override
    public List<ShowResponse> getAllShows() {
        return showRepository.findAll()
                .stream()
                .map(show -> new ShowResponse(
                        show.getId(),
                        show.getMovie().getMovieName(),
                        show.getTheatre().getTheatreName(),
                        show.getScreenNumber(),
                        show.getShowDate(),
                        show.getShowTime(),
                        show.getTicketPrice(),
                        show.getAvailableSeats()))
                .collect(Collectors.toList());
    }

    @Override
    public ShowResponse getShowById(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        return new ShowResponse(
                show.getId(),
                show.getMovie().getMovieName(),
                show.getTheatre().getTheatreName(),
                show.getScreenNumber(),
                show.getShowDate(),
                show.getShowTime(),
                show.getTicketPrice(),
                show.getAvailableSeats());
    }

    @Override
    public ShowResponse updateShow(Long id, ShowRequest request) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        Theatre theatre = theatreRepository.findById(request.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setScreenNumber(request.getScreenNumber());
        show.setShowDate(request.getShowDate());
        show.setShowTime(request.getShowTime());
        show.setTicketPrice(request.getTicketPrice());
        show.setAvailableSeats(request.getAvailableSeats());
        Show updatedShow = showRepository.save(show);
        return new ShowResponse(
                updatedShow.getId(),
                updatedShow.getMovie().getMovieName(),
                updatedShow.getTheatre().getTheatreName(),
                updatedShow.getScreenNumber(),
                updatedShow.getShowDate(),
                updatedShow.getShowTime(),
                updatedShow.getTicketPrice(),
                updatedShow.getAvailableSeats());
    }

    @Override
    public void deleteShow(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        showRepository.delete(show);
    }
}