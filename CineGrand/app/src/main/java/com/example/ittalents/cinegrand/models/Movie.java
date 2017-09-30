package com.example.ittalents.cinegrand.models;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String infoMovie;
    private String description;
    private String trailer;
    private String program;
    private int imgRes;
    private int numOfLikes;

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

    public Movie(String title, String infoMovie, String description, String trailer, String program, int imgRes) {
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
        if (program != null && !program.isEmpty()) {
            this.program = program;
        }
        if (imgRes > 0) {
            this.imgRes = imgRes;
        }
        this.numOfLikes = 0;
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

    public String getProgram() {
        return program;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }
}