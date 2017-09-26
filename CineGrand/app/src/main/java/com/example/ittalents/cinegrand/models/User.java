package com.example.ittalents.cinegrand.models;

import android.content.Context;

import com.example.ittalents.cinegrand.activities.SignInActivity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

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
        boolean lenghtPass = false;
        boolean hasDigit = false;
        boolean hasCapitalLetter = false;
        boolean hasSmallLetter = false;
        if (!pass.matches("[;\"]") && pass != null && !pass.isEmpty() && pass.length() >= 5) {
            lenghtPass = true;
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
        return (lenghtPass && hasDigit && hasSmallLetter && hasCapitalLetter);
    }
}