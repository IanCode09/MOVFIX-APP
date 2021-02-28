package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieGenreModel {
    @SerializedName("id")
    @Expose
    private int genreId;

    @SerializedName("name")
    @Expose
    private String genreName;

    public MovieGenreModel(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }
}
