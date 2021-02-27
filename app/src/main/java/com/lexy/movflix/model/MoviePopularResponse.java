package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviePopularResponse {
    private int page;

    @SerializedName("results")
    @Expose
    private List<MoviePopularModel> popularResults = null;

    public int getPage() {
        return page;
    }

    public List<MoviePopularModel> getPopular() {
        return popularResults;
    }
}
