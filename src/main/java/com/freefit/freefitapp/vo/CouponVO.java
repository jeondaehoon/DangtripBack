package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class CouponVO {
    private String couponId;
    private String title;
    private String tag;
    private String description;
    private String discountValue;
    private String validFrom;
    private String validUntil;
    private String createdAt;

    private String userCouponId;
    private String userId;
    private String issuedAt;
    private String usedAt;
    private String status;
}
