package com.example.ittalents.cinegrand.models;

public class Reservation {

    private String userEmail;
    private Projection projection;

    public Reservation(String userEmail, Projection projection) {
        if (userEmail != null && !userEmail.isEmpty()) {
            this.userEmail = userEmail;
        }
        if (projection != null) {
            this.projection = projection;
        }
    }
}
