package com.lexy.movflix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lexy.movflix.R;
import com.lexy.movflix.model.MovieModel;

import java.util.List;

public class MoviePopularAdapter extends RecyclerView.Adapter<MoviePopularAdapter.PopularViewHolder> {

    private Context context;
    private List<MovieModel> popularMovieList;

    public MoviePopularAdapter(Context context, List<MovieModel> popularMovieList) {
        this.context = context;
        this.popularMovieList = popularMovieList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_popular_items, parent, false);

        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        holder.popularMovieTitle.setText(popularMovieList.get(position).getTitle());
        Glide.with(context).load(popularMovieList.get(position).getPoster_path()).into(holder.popularMovieImage);
    }

    @Override
    public int getItemCount() {
        return popularMovieList.size();
    }


    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView popularMovieImage;
        TextView popularMovieTitle;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            popularMovieImage = itemView.findViewById(R.id.movie_popular_image);
            popularMovieTitle = itemView.findViewById(R.id.movie_popular_title);
        }
    }
}
