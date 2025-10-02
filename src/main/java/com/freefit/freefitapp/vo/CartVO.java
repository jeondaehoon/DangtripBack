package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class CartVO {

    private int     cartId;
    private String  userId;
    private int     productId;
    private int     quantity;
    private String  createdAt;
    private String  updatedAt;

    //상품
    private int categoryId;
    private String categoryName;
    private String iconUrl;
    private String name;
    private String description;
    private int price;
    private String imageUrl;
    private double rating;
    private int reviewsCount;
    private int salesCount;
}
