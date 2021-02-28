package com.lexy.movflix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lexy.movflix.R;
import com.lexy.movflix.model.MovieGenreModel;

import java.util.List;

public class MovieGenreAdapter extends RecyclerView.Adapter<MovieGenreAdapter.GenreViewHolder> {
    private Context context;
    private List<MovieGenreModel> genreMovieList;

    public MovieGenreAdapter(Context context, List<MovieGenreModel> genreMovieList) {
        this.context = context;
        this.genreMovieList = genreMovieList;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_genre_items, parent, false);

        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        holder.genreMovieName.setText(genreMovieList.get(position).getGenreName());
    }

    @Override
    public int getItemCount() {
        return genreMovieList.size();
    }


    public static class GenreViewHolder extends RecyclerView.ViewHolder {
        TextView genreMovieName;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            genreMovieName = itemView.findViewById(R.id.movie_genre_name);
        }
    }
}
