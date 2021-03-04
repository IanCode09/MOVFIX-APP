package com.lexy.movflix.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lexy.movflix.R;
import com.lexy.movflix.activity.MovieDetailActivity;
import com.lexy.movflix.model.MovieModel;

import java.util.List;

public class MovieByGenreAdapter extends RecyclerView.Adapter<MovieByGenreAdapter.MovieByGenreViewHolder> {

    private Context context;
    private List<MovieModel> movieByGenreList;

    public MovieByGenreAdapter(Context context, List<MovieModel> movieByGenreList) {
        this.context = context;
        this.movieByGenreList = movieByGenreList;
    }

    @NonNull
    @Override
    public MovieByGenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_detail_items, parent, false);

        return new MovieByGenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieByGenreViewHolder holder, int position) {
        int MovieId = movieByGenreList.get(position).getMovie_id();

        holder.movieTitle.setText(movieByGenreList.get(position).getTitle());
        holder.movieRating.setText(String.valueOf(movieByGenreList.get(position).getVote_average()));
        Glide.with(context).load(movieByGenreList.get(position).getPoster_path()).into(holder.movieImage);

        holder.movieTitle.setOnClickListener(v -> {
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("MovieId", MovieId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieByGenreList.size();
    }

    public class MovieByGenreViewHolder extends RecyclerView.ViewHolder {

        ImageView movieImage;
        TextView movieTitle, movieGenre, movieRating;

        public MovieByGenreViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieGenre = itemView.findViewById(R.id.movie_genre);
            movieRating = itemView.findViewById(R.id.movie_rating);
            movieImage = itemView.findViewById(R.id.movie_image);
        }
    }
}
