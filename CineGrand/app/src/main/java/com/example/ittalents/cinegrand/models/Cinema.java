package com.example.ittalents.cinegrand.models;

import java.io.Serializable;

public class Cinema implements Serializable {

    private String name;
    private String contactNumber;
    private String address;
    private int imgRes;

    public Cinema(String name, String address, String contactNumber, int imgRes) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
        if (contactNumber != null && !contactNumber.isEmpty()) {
            this.contactNumber = contactNumber;
        }
        if(imgRes > 0) {
            this.imgRes = imgRes;
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getImgRes() {
        return imgRes;
    }
}