package com.lexy.movflix.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lexy.movflix.R;
import com.lexy.movflix.adapter.MovieGenreInfoAdapter;
import com.lexy.movflix.model.MovieDetailModel;
import com.lexy.movflix.model.MovieGenreModel;
import com.lexy.movflix.model.MovieGenreResponse;
import com.lexy.movflix.retrofit.ApiService;
import com.lexy.movflix.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    ApiService apiService;
    TextView movieDetailName, movieDetailRating, movieDetailRelease, movieDetailTagline, movieDetailOverview;
    ImageView movieDetailImage;

    RecyclerView genreInfoRecyclerView;
    MovieGenreInfoAdapter movieGenreInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Bundle extra = getIntent().getExtras();

        movieDetailName = findViewById(R.id.movie_detail_name);
        movieDetailRating = findViewById(R.id.movie_detail_rating);
        movieDetailRelease = findViewById(R.id.movie_detail_release);
        movieDetailTagline = findViewById(R.id.movie_detail_tagline);
        movieDetailOverview = findViewById(R.id.movie_detail_overview);
        movieDetailImage = findViewById(R.id.movie_detail_image);

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<MovieDetailModel> callMovieDetail = apiService.getDetailMovie(extra.getInt("MovieId"));
        callMovieDetail.enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {
                MovieDetailModel movieDetailModel = response.body();

                movieDetailName.setText(movieDetailModel.getMovieTitle());
                movieDetailRating.setText(String.valueOf(movieDetailModel.getMovieVoteAverage()));
                movieDetailRelease.setText(movieDetailModel.getMovieRelease());
                movieDetailTagline.setText(movieDetailModel.getMovieTagLine());
                movieDetailOverview.setText(movieDetailModel.getMovieOverview());
                Glide.with(MovieDetailActivity.this).load(movieDetailModel.getMoviePoster()).into(movieDetailImage);
            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                Log.d("TAG", "Error: " + t);
            }
        });

        Call<MovieGenreResponse> callGenre = apiService.getDetailGenreMovie(extra.getInt("MovieId"));
        callGenre.enqueue(new Callback<MovieGenreResponse>() {
            @Override
            public void onResponse(Call<MovieGenreResponse> callGenre, Response<MovieGenreResponse> response) {
                MovieGenreResponse movieGenreResponse = response.body();

                getMovieGenreInfoList(movieGenreResponse.getGenreResults());
            }

            @Override
            public void onFailure(Call<MovieGenreResponse> callGenre, Throwable t) {
                Toast.makeText(MovieDetailActivity.this, "Server is not responding", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMovieGenreInfoList(List<MovieGenreModel> genreInfo) {
        genreInfoRecyclerView = findViewById(R.id.movie_genre_info_recycler);
        movieGenreInfoAdapter = new MovieGenreInfoAdapter(this, genreInfo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        genreInfoRecyclerView.setLayoutManager(layoutManager);
        genreInfoRecyclerView.setAdapter(movieGenreInfoAdapter);
    }
}