package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class walksVO {
    private int id;
    private String title;
    private String tag;
    private double rating;
    private double distanceKm;
    private double lat;
    private double lon;
    private String createdAt;
    private double distanceCalc;
    private String imageUrl;
    private String description;
}
