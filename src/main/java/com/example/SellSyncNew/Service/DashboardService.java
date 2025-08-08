package com.example.SellSyncNew.Service;

import com.example.SellSyncNew.DTO.DashboardSummaryDTO;
import com.example.SellSyncNew.Repository.ManufacturerRepository;
import com.example.SellSyncNew.Repository.OrderRepository;
import com.example.SellSyncNew.Repository.ProductRepository;
import com.example.SellSyncNew.Repository.WholesalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private ManufacturerRepository manufacturerRepo;

    @Autowired
    private WholesalerRepository wholesalerRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    public DashboardSummaryDTO getDashboardSummary() {
        long totalUsers = manufacturerRepo.count() + wholesalerRepo.count();
        long totalOrders = orderRepo.countOrders();
        double totalRevenue = orderRepo.calculateTotalRevenue();
        long totalProducts = productRepo.count();

        return new DashboardSummaryDTO(totalUsers, totalOrders, totalRevenue, totalProducts);
    }
}
