package com.movieticket.movie_booking_system.dto;

import java.time.LocalDateTime;

public class BookingResponse {
    private Long bookingId;
    private String userName;
    private String movieName;
    private String theatreName;
    private String seatNumber;
    private Double totalAmount;
    private String bookingStatus;
    private LocalDateTime bookingTime;

    public BookingResponse() {
    }

    public BookingResponse(Long bookingId,
            String userName,
            String movieName,
            String theatreName,
            String seatNumber,
            Double totalAmount,
            String bookingStatus,
            LocalDateTime bookingTime) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.bookingTime = bookingTime;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}