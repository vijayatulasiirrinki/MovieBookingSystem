package com.movieticket.movie_booking_system.dto;

public class SeatResponse {
    private Long id;
    private String movieName;
    private String theatreName;
    private String seatNumber;
    private String seatType;
    private Double price;
    private String status;

    public SeatResponse() {
    }

    public SeatResponse(Long id,
            String movieName,
            String theatreName,
            String seatNumber,
            String seatType,
            Double price,
            String status) {
        this.id = id;
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.status = status;
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
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

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}