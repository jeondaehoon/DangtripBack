package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class UserCouponVO {
    private String userCouponId;
    private String userId;
    private String couponId;
    private String issuedAt;
    private String usedAt;
    private String status;
}
