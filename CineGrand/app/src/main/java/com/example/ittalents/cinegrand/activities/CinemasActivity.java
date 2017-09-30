package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Cinema;
import com.example.ittalents.cinegrand.models.User;

import java.util.ArrayList;

public class CinemasActivity extends Activity {

    private static ArrayList<Cinema> cinemas = new ArrayList<>();

    static {
        addCinema();
    }

    private ImageView imageView;
    private Button parkCenterButton;
    private Button ringMallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemas);

        imageView = (ImageView)findViewById(R.id.cinema_logo_large);
        imageView.setImageResource(R.drawable.cine_grand_logo_large);
        parkCenterButton = (Button)findViewById(R.id.park_center_button);
        ringMallButton = (Button)findViewById(R.id.ring_mall_button);

        final User u = (User) getIntent().getSerializableExtra("user");

        parkCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListViewMoviesActivity.class);
                intent.putExtra("Kino", cinemas.get(0));
                intent.putExtra("user", u);
                startActivity(intent);
            }
        });

        ringMallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListViewMoviesActivity.class);
                intent.putExtra("Kino", cinemas.get(1));
                intent.putExtra("user", u);
                startActivity(intent);
            }
        });
    }

    private static void addCinema() {
        final Cinema parkCenter = new Cinema("CineGrand Park Center Sofia", "2 Arsenalski blvd, 1421 Sofia",
                "+359 875 300 985, +359 875 300 982", R.drawable.park_center_map);
        cinemas.add(parkCenter);

        final Cinema ringMall = new Cinema("CineGrand Ring Mall Sofia", " „Okolovrasten pat“ 214, Sofia",
                "+359 875 300 996, +359 875 200 993", R.drawable.ring_mall_map);
        cinemas.add(ringMall);
    }
}
