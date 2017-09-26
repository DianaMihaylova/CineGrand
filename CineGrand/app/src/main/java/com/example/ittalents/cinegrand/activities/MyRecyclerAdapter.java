package com.example.ittalents.cinegrand.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.data.DataProviderMovies;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerViewHolder> {

    private ArrayList<DataProviderMovies> arrayList = new ArrayList<>();

    public MyRecyclerAdapter(ArrayList<DataProviderMovies> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyRecyclerViewHolder myRecyclerViewHolder = new MyRecyclerViewHolder(view);
        return myRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {

        DataProviderMovies dataProviderMovies = arrayList.get(position);
        holder.imageView.setImageResource(dataProviderMovies.getImgRes());
        holder.infoMovie.setText(dataProviderMovies.getInfoMovie());
        holder.movieName.setText(dataProviderMovies.getNameMovie());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView movieName, infoMovie;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img);
            movieName = (TextView) itemView.findViewById(R.id.name_movie);
            infoMovie = (TextView) itemView.findViewById(R.id.genre_info);
        }
    }
}
