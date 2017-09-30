package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Movie;
import com.example.ittalents.cinegrand.models.User;

import java.util.ArrayList;

public class ListViewMoviesActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private String[] movieName, infoMovies;
    private Button otherCinemaBtn, contactsBtn;
    private int[] imgRes = {R.drawable.it, R.drawable.xii_a, R.drawable.despicable_me_3,
            R.drawable.hitmans_bodyguard, R.drawable.the_nut_job_2_nutty_by_nature, R.drawable.logan_lucky};
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_movies);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        movieName = getResources().getStringArray(R.array.movies_names);
        infoMovies = getResources().getStringArray(R.array.genre_of_movies);
        contactsBtn = (Button) findViewById(R.id.button_contacts);
        otherCinemaBtn = (Button) findViewById(R.id.button_choose_cinema);
        movies  = new ArrayList<>();

        int i = 0;
        for (String name: movieName) {
            Movie m = new Movie(imgRes[i], name, infoMovies[i]);
            movies.add(m);
            i++;
        }

        adapter = new MyRecyclerAdapter(movies, this);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        contactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ContactsActivity.class);
                startActivity(i);
            }
        });

        otherCinemaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CinemasActivity.class);
                startActivity(i);
            }
        });
    }
}