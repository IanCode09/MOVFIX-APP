package com.lexy.movflix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lexy.movflix.R;
import com.lexy.movflix.model.MovieProductionModel;

import java.util.List;

public class MovieProductionAdapter extends RecyclerView.Adapter<MovieProductionAdapter.MovieProductionViewHolder> {

    private Context context;
    private List<MovieProductionModel> movieProductionList;

    public MovieProductionAdapter(Context context, List<MovieProductionModel> movieProductionList) {
        this.context = context;
        this.movieProductionList = movieProductionList;
    }

    @NonNull
    @Override
    public MovieProductionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_production_info, parent, false);

        return new MovieProductionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieProductionViewHolder holder, int position) {
        holder.movieProductionInfo.setText(movieProductionList.get(position).getGetProductionName());
    }

    @Override
    public int getItemCount() {
        return movieProductionList.size();
    }

    public class MovieProductionViewHolder extends RecyclerView.ViewHolder {

        TextView movieProductionInfo;

        public MovieProductionViewHolder(@NonNull View itemView) {
            super(itemView);
            movieProductionInfo = itemView.findViewById(R.id.tv_production_info);
        }
    }
}
