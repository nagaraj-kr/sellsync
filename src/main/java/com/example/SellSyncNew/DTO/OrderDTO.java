package com.example.SellSyncNew.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long orderId;
    private String orderDate;
    private String supplierName;
    private String buyerName;
    private int itemCount;
    private double totalAmount;
    private String orderStatus;
    private String productName;
}
