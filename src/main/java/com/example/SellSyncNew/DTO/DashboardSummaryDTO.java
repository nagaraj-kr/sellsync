package com.example.SellSyncNew.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DashboardSummaryDTO {
    private long totalUsers;
    private long totalOrders;
    private double totalRevenue;
    private long totalProducts;

}
