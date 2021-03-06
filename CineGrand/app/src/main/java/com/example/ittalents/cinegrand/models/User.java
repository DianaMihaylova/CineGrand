package com.example.ittalents.cinegrand.models;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String pass;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public boolean isValidMail(String email) {
        if ((!email.matches("[;\"]")) && (email != null) && (!email.isEmpty())) {
            return true;
        }
        return false;
    }

    public boolean isStrongPass(String pass) {
        boolean lengthPass = false;
        boolean hasDigit = false;
        boolean hasCapitalLetter = false;
        boolean hasSmallLetter = false;
        if (!pass.matches("[;\"]") && pass != null && !pass.isEmpty() && pass.length() >= 5) {
            lengthPass = true;
            for (int i = 0; i < pass.length(); i++) {
                if (pass.charAt(i) >= '1' && pass.charAt(i) <= '9') {
                    hasDigit = true;
                }
                if (pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z') {
                    hasSmallLetter = true;
                }
                if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z') {
                    hasCapitalLetter = true;
                }
            }
        }
        return (lengthPass && hasDigit && hasSmallLetter && hasCapitalLetter);
    }
}