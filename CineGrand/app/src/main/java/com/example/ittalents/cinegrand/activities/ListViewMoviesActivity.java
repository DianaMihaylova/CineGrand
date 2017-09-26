package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.data.DataProviderMovies;

import java.util.ArrayList;

public class ListViewMoviesActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private String[] movieName, infoMovies;
    private int[] imgRes = {R.drawable.it, R.drawable.xii_a, R.drawable.despicable_me_3,
            R.drawable.hitmans_bodyguard, R.drawable.the_nut_job_2_nutty_by_nature, R.drawable.logan_lucky};
    private ArrayList<DataProviderMovies> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_movies);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        movieName = getResources().getStringArray(R.array.movies_names);
        infoMovies = getResources().getStringArray(R.array.genre_of_movies);
        arrayList = new ArrayList<>();
        int i = 0;

        for (String name: movieName) {
            DataProviderMovies dataProviderMovies = new DataProviderMovies(imgRes[i], name, infoMovies[i]);
            arrayList.add(dataProviderMovies);
            i++;
        }

        adapter = new MyRecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}
