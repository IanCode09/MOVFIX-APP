package com.lexy.movflix.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.lexy.movflix.R;
import com.lexy.movflix.adapter.MoviePopularAdapter;
import com.lexy.movflix.model.MoviePopularModel;
import com.lexy.movflix.model.MoviePopularResponse;
import com.lexy.movflix.retrofit.ApiService;
import com.lexy.movflix.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiService apiService;
    RecyclerView popularMovieRecyclerView;
    MoviePopularAdapter moviePopularAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        Call<MoviePopularResponse> call = apiService.getAllData();
        call.enqueue(new Callback<MoviePopularResponse>() {
            @Override
            public void onResponse(Call<MoviePopularResponse> call, Response<MoviePopularResponse> response) {
                MoviePopularResponse moviePopularResponse = response.body();

                getMoviePopularList(moviePopularResponse.getPopular());
            }

            @Override
            public void onFailure(Call<MoviePopularResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server is not responding", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMoviePopularList(List<MoviePopularModel> movieList) {
        popularMovieRecyclerView = findViewById(R.id.popular_movie_recycler);
        moviePopularAdapter = new MoviePopularAdapter(this, movieList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularMovieRecyclerView.setLayoutManager(layoutManager);
        popularMovieRecyclerView.setAdapter(moviePopularAdapter);
    }
}