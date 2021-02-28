package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieGenreResponse {
    @SerializedName("genres")
    @Expose
    private List<MovieGenreModel> genreResults = null;

    public List<MovieGenreModel> getGenreResults() {
        return genreResults;
    }
}
