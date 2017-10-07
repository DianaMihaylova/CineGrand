package com.example.ittalents.cinegrand.models;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String infoMovie;
    private String description;
    private String trailer;
    private int imgRes;
    private int imgProgram;
    private String reservationLink;

    public Movie(int imgRes, String title, String infoMovie) {
        if (imgRes > 0) {
            this.imgRes = imgRes;
        }
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (infoMovie != null && !infoMovie.isEmpty()) {
            this.infoMovie = infoMovie;
        }
    }

    public Movie(String title, String infoMovie, String description, String trailer, int imgRes,
                 int imgProgram, String reservationLink) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (infoMovie != null && !infoMovie.isEmpty()) {
            this.infoMovie = infoMovie;
        }
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
        if (trailer != null && !trailer.isEmpty()) {
            this.trailer = trailer;
        }
        if (imgRes > 0) {
            this.imgRes = imgRes;
        }
        if (imgProgram > 0) {
            this.imgProgram = imgProgram;
        }
        if (reservationLink != null && !reservationLink.isEmpty()) {
            this.reservationLink = reservationLink;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTrailer() {
        return trailer;
    }

    public int getImgRes() {
        return imgRes;
    }

    public String getInfoMovie() {
        return infoMovie;
    }

    public int getImgProgram() {
        return this.imgProgram;
    }

    public String getReservationLink() {
        return this.reservationLink;
    }
}