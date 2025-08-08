package com.example.SellSyncNew.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    public String productName;
    public String category;
    public String manufacturer;
    public int quantity;
    public String specifications;
    public String deadline;
}
