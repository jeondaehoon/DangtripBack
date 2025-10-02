package com.freefit.freefitapp.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrdersVO {

    private int orderId;
    private String userId;
    private String name;
    private String phone;
    private String address;
    private String addressDetail;
    private String payment;
    private int totalPrice;
    private String orderStatus;
    private String createdAt;
    private String updatedAt;

    private List<OrderItemsVO> items;
}
