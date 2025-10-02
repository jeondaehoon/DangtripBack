package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class OrderItemsVO {
    private int orderItemId;
    private int orderId;
    private int productId;
    private String productName;
    private int quantity;
    private int price;
    private String createdAt;
}
