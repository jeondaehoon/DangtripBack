package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class CafesVO {

    private int id;
    private String title;
    private String tag;
    private double rating;
    private String address;
    private String openingHours;
    private double lat;
    private double lon;
    private String createdAt;
    private String imageUrl;
    private Double distanceCalc;
    private String description;
}
