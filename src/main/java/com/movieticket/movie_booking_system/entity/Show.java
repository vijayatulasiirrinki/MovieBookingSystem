package com.movieticket.movie_booking_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;
    @Column(nullable = false)
    private Integer screenNumber;
    @Column(nullable = false)
    private LocalDate showDate;
    @Column(nullable = false)
    private LocalTime showTime;
    @Column(nullable = false)
    private Double ticketPrice;
    @Column(nullable = false)
    private Integer availableSeats;

    public Show() {
    }

    public Show(Long id, Movie movie, Theatre theatre, Integer screenNumber,
            LocalDate showDate, LocalTime showTime,
            Double ticketPrice, Integer availableSeats) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.screenNumber = screenNumber;
        this.showDate = showDate;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Integer getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}