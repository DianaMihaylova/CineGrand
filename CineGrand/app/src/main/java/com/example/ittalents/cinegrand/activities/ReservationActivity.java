package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Cinema;
import com.example.ittalents.cinegrand.models.Movie;

public class ReservationActivity extends Activity {

    private Button makeReservation, makeCall;
    private TextView contactUs;
    private ImageView imgProgram;
    private String phoneNumber, reservationLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Cinema kino = (Cinema) getIntent().getSerializableExtra("Kino");
        Movie film = (Movie) getIntent().getSerializableExtra("movie");

        makeCall = (Button) findViewById(R.id.dial_contact_number);
        makeReservation = (Button) findViewById(R.id.button_make_reservation);
        contactUs = (TextView) findViewById(R.id.id_contact_us);
        imgProgram = (ImageView) findViewById(R.id.program_image);

        phoneNumber = kino.getContactNumber();
        reservationLink = film.getReservationLink();


        imgProgram.setImageResource(film.getImgProgram());
        contactUs.setText("Or contact us: \n" + kino.getContactNumber());

        makeReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(Intent.ACTION_VIEW, Uri.parse(reservationLink));
                startActivity(openURL);
            }
        });

        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(call);
            }
        });

    }
}
