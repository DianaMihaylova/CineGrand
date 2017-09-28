package com.example.ittalents.cinegrand.models;

public class Movie {

    private static int num = 1;
    private int id;
    private String title;
    private String infoMovie;
    private String description;
    private String trailer;
    private int imgRes;
    private int numOfLikes;
    private int numOfDislikes;

    public Movie(int imgRes, String title, String infoMovie) {
        if (imgRes > 0) {
            this.imgRes = imgRes;
        }
        this.title = title;
        if (infoMovie != null && !infoMovie.isEmpty()) {
            this.infoMovie = infoMovie;
        }
    }

    public Movie(String title, String description, String trailer) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
        if (trailer != null) {
            this.trailer = trailer;
        }
        this.id = num++;
        this.numOfLikes = 0;
        this.numOfDislikes = 0;
    }

    public int getId() {
        return id;
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

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public int getNumOfDislikes() {
        return numOfDislikes;
    }

    public void setNumOfDislikes(int numOfDislikes) {
        this.numOfDislikes = numOfDislikes;
    }
}