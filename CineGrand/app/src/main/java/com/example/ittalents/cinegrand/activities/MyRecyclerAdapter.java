package com.example.ittalents.cinegrand.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Cinema;
import com.example.ittalents.cinegrand.models.Movie;
import com.example.ittalents.cinegrand.models.User;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerViewHolder> {

    private ArrayList<Movie> movies = new ArrayList<>();
    private Context context;

    public MyRecyclerAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyRecyclerViewHolder myRecyclerViewHolder = new MyRecyclerViewHolder(view,context,movies);
        return myRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {

        Movie movie = movies.get(position);
        holder.imageView.setImageResource(movie.getImgRes());
        holder.infoMovie.setText(movie.getInfoMovie());
        holder.movieName.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView movieName, infoMovie;
        ArrayList<Movie> movies;
        Context context;

        public MyRecyclerViewHolder(View itemView, Context context, ArrayList<Movie> movies) {
            super(itemView);
            this.context = context;
            this.movies = movies;

            imageView = (ImageView) itemView.findViewById(R.id.img);
            movieName = (TextView) itemView.findViewById(R.id.name_movie);
            infoMovie = (TextView) itemView.findViewById(R.id.genre_info);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Movie movie = this.movies.get(position);
            Cinema kino = (Cinema) ((ListViewMoviesActivity) context).getIntent().getSerializableExtra("Kino");
            User u = (User) ((ListViewMoviesActivity) context).getIntent().getSerializableExtra("user");
            Intent i = new Intent(this.context, MovieDetailsActivity.class);
            i.putExtra("movie", movie);
            i.putExtra("user", u);
            i.putExtra("Kino", kino);
            this.context.startActivity(i);
        }
    }
}