package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class HospitalVO {
    private int id;
    private String name;
    private String tag;
    private double rating;
    private String address;
    private String openingHours;
    private String phone;
    private String emergencyYn;
    private double lat;
    private double lon;
    private String createdAt;
    private String imageUrl;
}

