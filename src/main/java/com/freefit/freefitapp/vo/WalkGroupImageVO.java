package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class WalkGroupImageVO {
    private Long imageId;
    private Long groupId;
    private String imageUrl;
    private String uploadedAt;
}
