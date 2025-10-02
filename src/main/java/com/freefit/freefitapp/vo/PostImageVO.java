package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class PostImageVO {

    private int imageId;
    private int postId;
    private String imageUrl;
    private String createdAt;

}
