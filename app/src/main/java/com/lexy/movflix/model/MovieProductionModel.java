package com.lexy.movflix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieProductionModel {
    @SerializedName("id")
    @Expose
    private int productionId;

    @SerializedName("logo_path")
    @Expose
    private String productionImage;

    @SerializedName("name")
    @Expose
    private String getProductionName;

    public MovieProductionModel(int productionId, String productionImage, String getProductionName) {
        this.productionId = productionId;
        this.productionImage = productionImage;
        this.getProductionName = getProductionName;
    }

    public int getProductionId() {
        return productionId;
    }

    public String getProductionImage() {
        return productionImage;
    }

    public String getGetProductionName() {
        return getProductionName;
    }
}
