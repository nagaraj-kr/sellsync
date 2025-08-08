package com.example.SellSyncNew.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WholesalerDto {
    private String email;
    private String organizationName;
    private String address;
    private String gstNumber;
    private String phone;

    // Getters and Setters
}
