package com.lexy.movflix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lexy.movflix.R;
import com.lexy.movflix.model.MovieDetailModel;

public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.DetailViewHolder> {
    private Context context;
    private MovieDetailModel movieDetailList;

    public MovieDetailAdapter(Context context, MovieDetailModel movieDetailList) {
        this.context = context;
        this.movieDetailList = movieDetailList;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_detail_items, parent, false);

        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder {

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
