package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class WalkGroupGalleryVO {
    private Long galleryId;
    private Long groupId;
    private String imageUrl;
    private String uploadedAt;
    private String uploadedBy;
}
