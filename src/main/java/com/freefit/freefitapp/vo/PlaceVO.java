package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class PlaceVO {
    private int id;
    private String title;
    private String tag;
    private double rating;
    private String type;
    private double lat;
    private double lon;
    private String address;
    private String imageUrl;
}
