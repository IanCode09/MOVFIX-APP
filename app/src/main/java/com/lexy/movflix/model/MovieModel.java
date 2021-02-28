package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lexy.movflix.utils.Credentials;

public class MovieModel {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("poster_path")
    @Expose
    private String poster_path;

    @SerializedName("release_date")
    @Expose
    private String release_date;

    @SerializedName("overview")
    @Expose
    private String movie_overview;

    @SerializedName("id")
    @Expose
    private int movie_id;

    @SerializedName("vote_average")
    @Expose
    private float vote_average;

    String imageUrl = Credentials.IMAGE_URL;

    public MovieModel(String title, String poster_path, String release_date, String movie_overview, int movie_id, float vote_average) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.movie_overview = movie_overview;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return  "https://image.tmdb.org/t/p/w185_and_h278_bestv2" + poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getMovie_overview() {
        return movie_overview;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public float getVote_average() {
        return vote_average;
    }
}
