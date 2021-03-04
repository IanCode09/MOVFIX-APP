package com.lexy.movflix.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lexy.movflix.R;
import com.lexy.movflix.adapter.MovieByGenreAdapter;
import com.lexy.movflix.model.MovieGenreResponse;
import com.lexy.movflix.model.MovieModel;
import com.lexy.movflix.model.MovieResponse;
import com.lexy.movflix.retrofit.ApiService;
import com.lexy.movflix.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieByGenreActivity extends AppCompatActivity {

    ApiService apiService;
    MovieByGenreAdapter movieByGenreAdapter;
    RecyclerView movieByGenreRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_by_genre);

        Bundle extra = getIntent().getExtras();

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        Call<MovieResponse> callMovieByGenre = apiService.getMovieByGenre(extra.getInt("GenreId"));
        callMovieByGenre.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> callMovieByGenre, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();

                getMovieByGenreList(movieResponse.getPopular());
            }

            @Override
            public void onFailure(Call<MovieResponse> callMovieByGenre, Throwable t) {
                Log.d("TAG", "Error: " + t);
            }
        });
    }

    private void getMovieByGenreList(List<MovieModel> movieByGenreList) {
        movieByGenreRecyclerView = findViewById(R.id.detail_movie_recycler);
        movieByGenreAdapter = new MovieByGenreAdapter(this, movieByGenreList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        movieByGenreRecyclerView.setLayoutManager(layoutManager);
        movieByGenreRecyclerView.setAdapter(movieByGenreAdapter);
    }
}