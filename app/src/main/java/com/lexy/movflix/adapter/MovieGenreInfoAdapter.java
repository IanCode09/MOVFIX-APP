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

public class MovieGenreInfoAdapter extends RecyclerView.Adapter<MovieGenreInfoAdapter.MovieGenreInfoViewHolder> {

    private Context context;
    private List<MovieGenreModel> movieGenreInfoList;

    public MovieGenreInfoAdapter(Context context, List<MovieGenreModel> movieGenreInfoList) {
        this.context = context;
        this.movieGenreInfoList = movieGenreInfoList;
    }

    @NonNull
    @Override
    public MovieGenreInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_genre_info, parent, false);

        return new MovieGenreInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieGenreInfoViewHolder holder, int position) {
        holder.movieGenreInfo.setText(movieGenreInfoList.get(position).getGenreName());
    }

    @Override
    public int getItemCount() {
        return movieGenreInfoList.size();
    }

    public class MovieGenreInfoViewHolder extends RecyclerView.ViewHolder{

        TextView movieGenreInfo;

        public MovieGenreInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            movieGenreInfo = itemView.findViewById(R.id.tv_genre_info);
        }
    }
}
