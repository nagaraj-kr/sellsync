package com.example.SellSyncNew.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutRequest {
    private List<CartItemDTO> cartItems;
    private Double totalAmount;
}
