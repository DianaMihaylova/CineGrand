package com.example.ittalents.cinegrand.models;

public class Movie {

    private static int num = 1;
    private int id;
    private String title;
    private String description;
    private String poster;
    private String trailer;
    private int numOfLikes;
    private int numOfDislikes;

    public Movie(String title, String description, String poster, String trailer) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
        if (poster != null && !poster.isEmpty()) {
            this.poster = poster;
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