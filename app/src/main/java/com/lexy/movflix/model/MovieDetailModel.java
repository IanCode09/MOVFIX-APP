package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDetailModel {
    @SerializedName("title")
    @Expose
    private String movieTitle;

    @SerializedName("overview")
    @Expose
    private String movieOverview;

    @SerializedName("poster_path")
    @Expose
    private String moviePoster;

    @SerializedName("release_date")
    @Expose
    private String movieRelease;

    @SerializedName("status")
    @Expose
    private String movieStatus;

    @SerializedName("tagline")
    @Expose
    private String movieTagLine;

    @SerializedName("vote_average")
    @Expose
    private Float movieVoteAverage;

    public MovieDetailModel(String movieTitle, String movieOverview, String moviePoster, String movieRelease, String movieStatus, String movieTagLine, Float movieVoteAverage) {
        this.movieTitle = movieTitle;
        this.movieOverview = movieOverview;
        this.moviePoster = moviePoster;
        this.movieRelease = movieRelease;
        this.movieStatus = movieStatus;
        this.movieTagLine = movieTagLine;
        this.movieVoteAverage = movieVoteAverage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public String getMovieTagLine() {
        return movieTagLine;
    }

    public Float getMovieVoteAverage() {
        return movieVoteAverage;
    }
}
