package com.movieticket.movie_booking_system.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowResponse {
    private Long id;
    private String movieName;
    private String theatreName;
    private Integer screenNumber;
    private LocalDate showDate;
    private LocalTime showTime;
    private Double ticketPrice;
    private Integer availableSeats;

    public ShowResponse() {
    }

    public ShowResponse(Long id, String movieName, String theatreName,
            Integer screenNumber, LocalDate showDate,
            LocalTime showTime, Double ticketPrice,
            Integer availableSeats) {
        this.id = id;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.screenNumber = screenNumber;
        this.showDate = showDate;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public Integer getScreenNumber() {
        return screenNumber;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setScreenNumber(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}