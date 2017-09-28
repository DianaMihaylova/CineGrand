package com.example.ittalents.cinegrand.models;

public class Projection {

    private static int num = 1;
    private int id;
    private int ticketCount;
    private int bookedTicketCount;
    private int cinemaID;
    private int movieID;

    public Projection(int cinemaID, int movieID) {
        if (cinemaID > 0) {
            this.cinemaID = cinemaID;
        }
        if (movieID > 0) {
            this.movieID = movieID;
        }
        this.id = num++;
        this.ticketCount = 50;
        this.bookedTicketCount = 0;
    }

    public int getCinemaID() {
        return cinemaID;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public int getBookedTicketCount() {
        return bookedTicketCount;
    }

    public void setBookedTicketCount(int bookedTicketCount) {
        if (bookedTicketCount > 0) {
            this.bookedTicketCount = bookedTicketCount;
        }
    }

    public void setTicketCount(int ticketCount) {
        if (ticketCount > 0) {
            this.ticketCount = ticketCount;
        }
    }
}