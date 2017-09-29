package com.example.ittalents.cinegrand.models;

import java.io.Serializable;

public class Cinema implements Serializable {

    private String name;
    private String address;
    private String tel;
    private String map;

    public Cinema(String name, String address, String tel, String map) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
        if (tel != null && !tel.isEmpty()) {
            this.tel = tel;
        }
        if (map != null && !map.isEmpty()) {
            this.map = map;
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getMap() {
        return map;
    }
}