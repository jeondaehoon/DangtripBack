package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class LikeVO {
    private int likeId;
    private int postId;
    private String userId;
    private String createdAt;
}
