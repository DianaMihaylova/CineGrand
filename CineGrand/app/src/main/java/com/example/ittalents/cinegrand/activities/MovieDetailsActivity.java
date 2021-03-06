package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.data.DatabaseManager;
import com.example.ittalents.cinegrand.models.Cinema;
import com.example.ittalents.cinegrand.models.Movie;
import com.example.ittalents.cinegrand.models.User;

import java.util.ArrayList;

import static com.example.ittalents.cinegrand.activities.ListViewMoviesActivity.movies;

public class MovieDetailsActivity extends Activity {

    private ImageView imageView;
    private TextView info, trailer, numOfLikes;
    private Button programBtn;
    private Movie movieToProgram;
    private ImageButton likeBtn;
    private DatabaseManager myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imageView = (ImageView) findViewById(R.id.imageView3);
        info = (TextView) findViewById(R.id.textView2);
        trailer = (TextView) findViewById(R.id.textView);
        programBtn = (Button) findViewById(R.id.button_program);
        likeBtn = (ImageButton) findViewById(R.id.button_like);
        numOfLikes = (TextView) findViewById(R.id.num_likes);
        myDb = DatabaseManager.getDBManager(this);
        myDb.createDatabase();

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        final Cinema kino = (Cinema) getIntent().getSerializableExtra("Kino");

        for (Movie m: movies) {
            if (m.getTitle().equals(movie.getTitle())) {
                imageView.setImageResource(m.getImgRes());
                trailer.setText("Watch trailer here:\n" + m.getTrailer());
                info.setText(m.getDescription());
                movieToProgram = m;
            }
        }

        numOfLikes.setText(myDb.getNumOfLikes(movieToProgram.getTitle()) + "");

        programBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ReservationActivity.class);
                i.putExtra("movie", movieToProgram);
                i.putExtra("Kino", kino);
                startActivity(i);
            }
        });

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = (User) getIntent().getSerializableExtra("user");
                boolean result = myDb.addLike(u.getEmail(), movieToProgram.getTitle());
                if (result) {
                    Toast.makeText(MovieDetailsActivity.this, "You like this movie :)", Toast.LENGTH_LONG).show();
                    numOfLikes.setText(myDb.getNumOfLikes(movieToProgram.getTitle()) + "");
                } else {
                    myDb.deleteLike(u.getEmail(), movieToProgram.getTitle());
                    Toast.makeText(getBaseContext(), "You unlike this movie :(", Toast.LENGTH_LONG).show();
                    numOfLikes.setText(myDb.getNumOfLikes(movieToProgram.getTitle()) + "");
                }
                myDb.close();
            }
        });
    }
}