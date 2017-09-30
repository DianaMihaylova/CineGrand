package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Cinema;

public class ContactsActivity extends Activity {

    private Button movies;
    private TextView address, contactNumbers, cinemaName;
    private ImageView mapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        movies = (Button) findViewById(R.id.button_movies);
        address = (TextView) findViewById(R.id.address_textview);
        contactNumbers = (TextView) findViewById(R.id.phone_textview);
        cinemaName = (TextView) findViewById(R.id.cinema_name);
        mapImage = (ImageView) findViewById(R.id.map_image);

        final Cinema kino = (Cinema) getIntent().getExtras().get("Kino");

        cinemaName.setText(kino.getName());
        address.setText("Address: " + kino.getAddress());
        contactNumbers.setText("Contact number: " + kino.getContactNumber());
        mapImage.setImageResource(kino.getImgRes());

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListViewMoviesActivity.class);
                intent.putExtra("Kino", kino);
                startActivity(intent);
            }
        });
    }
}
