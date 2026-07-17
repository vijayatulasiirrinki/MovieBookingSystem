package com.movieticket.movie_booking_system.dto;

import java.time.LocalDate;

public class MovieResponse {
    private Long id;
    private String movieName;
    private String genre;
    private Integer duration;
    private String language;
    private LocalDate releaseDate;

    public MovieResponse() {
    }

    public MovieResponse(Long id, String movieName, String genre,
            Integer duration, String language,
            LocalDate releaseDate) {
        this.id = id;
        this.movieName = movieName;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}