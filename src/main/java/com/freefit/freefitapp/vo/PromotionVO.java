package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class PromotionVO {
    private int promoId;
    private String title;
    private String subtitle;
    private String tag;
    private String validUntil;
    private String createdAt;
}
