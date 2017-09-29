package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.data.DatabaseManager;
import com.example.ittalents.cinegrand.models.User;

public class SignInActivity extends Activity {

    private ImageView imageView;
    private EditText userName, pass;
    private Button signInBtn;
    private DatabaseManager myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.cine_grand_logo_small);
        userName = (EditText) findViewById(R.id.entered_mail);
        pass = (EditText) findViewById(R.id.entered_pass);
        signInBtn = (Button) findViewById(R.id.button_sign_in);
        myDb = DatabaseManager.getDBManager(this);
        myDb.createDatabase();
        setSignInBtn();
    }

    private void setSignInBtn() {
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameValue = userName.getText().toString();
                String passValue = pass.getText().toString();
                User u = new User(userNameValue, passValue);
                if (u != null && myDb.checkEmailPass(userNameValue, passValue)) {
                    Toast.makeText(getBaseContext(), "Sign in success! Welcome " + u.getEmail(), Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(getBaseContext(), ListViewMoviesActivity.class);
                    Intent i = new Intent(getBaseContext(), CinemasActivity.class); // tuk smenih putya pri logvane da otiva na cinema activitito, a ne kum lista s kinata
                    startActivity(i);
                    finish();
                } else {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SignInActivity.this);
                    alertBuilder.setMessage("Wrong e-mail or password! Try again.")
                            .setCancelable(false)
                            .setPositiveButton("BACK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog ad = alertBuilder.create();
                    ad.setTitle("WARNING MESSAGE");
                    ad.setIcon(R.drawable.warning_msg);
                    ad.show();
                }
            }
        });
    }
}