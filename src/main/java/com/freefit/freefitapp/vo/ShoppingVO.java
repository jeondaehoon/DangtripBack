package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class ShoppingVO {

    private int categoryId;
    private String categoryName;
    private String iconUrl;
    private int productId;
    private String name;
    private String description;
    private int price;
    private String imageUrl;
    private double rating;
    private int reviewsCount;
    private int salesCount;
    private String createdAt;
}
