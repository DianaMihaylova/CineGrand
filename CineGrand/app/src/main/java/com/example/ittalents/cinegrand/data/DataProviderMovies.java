package com.example.ittalents.cinegrand.data;

public class DataProviderMovies {

    private int imgRes;
    String nameMovie;
    private String infoMovie;

    public DataProviderMovies(int imgRes, String nameMovie, String infoMovie) {
        this.setImgRes(imgRes);
        this.setNameMovie(nameMovie);
        this.setInfoMovie(infoMovie);
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getInfoMovie() {
        return infoMovie;
    }

    public void setInfoMovie(String infoMovie) {
        this.infoMovie = infoMovie;
    }
}