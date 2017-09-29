package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ittalents.cinegrand.R;

public class CinemasActivity extends Activity {

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

        parkCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ParkCenterActivity.class);
                startActivity(i);
            }
        });

        ringMallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RingMallActivity.class);
                startActivity(i);
            }
        });
    }
}
