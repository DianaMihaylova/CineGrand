package com.example.ittalents.cinegrand.models;

public class Cinema {

    private static int num = 1;
    private int id;
    private String name;
    private String contacts;
    private String map;

    public Cinema(String name, String contacts, String map) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (contacts != null && !contacts.isEmpty()) {
            this.contacts = contacts;
        }
        if (map != null && !map.isEmpty()) {
            this.map = map;
        }
        this.id = num++;
    }

    public int getId() {
        return id;
    }
}
