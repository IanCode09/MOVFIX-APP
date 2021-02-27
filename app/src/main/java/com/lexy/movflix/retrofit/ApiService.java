package com.lexy.movflix.retrofit;

import com.lexy.movflix.model.MoviePopularResponse;
import com.lexy.movflix.utils.Credentials;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String api = Credentials.API_KEY;

    @GET("movie/popular?api_key=" + api)
    Call<MoviePopularResponse> getAllData();
}
