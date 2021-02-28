package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    private int page;

    @SerializedName("results")
    @Expose
    private List<MovieModel> popularResults = null;

    public int getPage() {
        return page;
    }

    public List<MovieModel> getPopular() {
        return popularResults;
    }
}
