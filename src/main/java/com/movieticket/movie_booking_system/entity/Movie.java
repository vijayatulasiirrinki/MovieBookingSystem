package com.movieticket.movie_booking_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String movieName;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private Integer duration;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(Long id, String movieName, String genre,
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
