package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class DeliveryAddressVO {

    private int addressId;
    private String userId;
    private String recipientName;
    private String phone;
    private String address;
    private String addressDetail;
    private String isDefault;
    private String createdAt;

}
