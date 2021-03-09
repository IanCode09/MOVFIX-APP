package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieFullDetailResponse {
    @SerializedName("production_companies")
    @Expose
    private List<MovieProductionModel> productionResults = null;

    public List<MovieProductionModel> getProductionResults() {
        return productionResults;
    }

//    @SerializedName("results")
//    @Expose
//    private videsMovieVideoModel videoResults = null;
//
//    public MovieVideoModel getVideoResults() {
//        return videoResults;
//    }

}
