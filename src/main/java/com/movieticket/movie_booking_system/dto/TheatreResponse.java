package com.movieticket.movie_booking_system.dto;

public class TheatreResponse {
    private Long id;
    private String theatreName;
    private String location;
    private String city;
    private Integer totalScreens;
    private String contactNumber;

    public TheatreResponse() {
    }

    public TheatreResponse(Long id, String theatreName, String location,
            String city, Integer totalScreens,
            String contactNumber) {
        this.id = id;
        this.theatreName = theatreName;
        this.location = location;
        this.city = city;
        this.totalScreens = totalScreens;
        this.contactNumber = contactNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(Integer totalScreens) {
        this.totalScreens = totalScreens;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}