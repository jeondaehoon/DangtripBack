package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class TrainingsVO {
    private int id;
    private String title;
    private String category;
    private String trainingLevel;
    private String duration;
    private String description;
    private String imageUrl;
    private String videoUrl;
    private String createdAt;
}
