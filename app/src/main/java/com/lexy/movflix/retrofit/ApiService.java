package com.lexy.movflix.retrofit;

import com.lexy.movflix.model.MovieDetailModel;
import com.lexy.movflix.model.MovieFullDetailResponse;
import com.lexy.movflix.model.MovieGenreResponse;
import com.lexy.movflix.model.MovieResponse;
import com.lexy.movflix.utils.Credentials;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    String api = Credentials.API_KEY;

    @GET("movie/popular?api_key=" + api)
    Call<MovieResponse> getAllData();

    @GET("genre/movie/list?api_key=" + api)
    Call<MovieGenreResponse> getGenreData();

    @GET("movie/{id}?api_key=" + api + "&append_to_response=videos")
    Call<MovieDetailModel> getDetailMovie(@Path("id") int movieId);

    @GET("movie/{id}?api_key=" + api + "&append_to_response=videos")
    Call<MovieGenreResponse> getDetailGenreMovie(@Path("id") int movieId);

    @GET("movie/{id}?api_key=" + api + "&append_to_response=videos")
    Call<MovieFullDetailResponse> getFullDetail(@Path("id") int movieId);

    /*
    @GET("movie/{id}?api_key=" + api + "&append_to_response=videos")
    Call<MovieProductionResponse> getDetailProductionMovie(@Path("id") int movieId);
    */

    @GET("discover/movie?api_key=" + api + "&with_genres=")
    Call<MovieResponse> getMovieByGenre(@Query("with_genres") int genreId);
}
