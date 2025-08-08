package com.example.SellSyncNew.Repository;

import com.example.SellSyncNew.Model.Manufacturer;
import com.example.SellSyncNew.Model.Order;
import com.example.SellSyncNew.Model.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderStatus(String status); // pending orders
    List<Order> findByOrderStatusNot(String status); // non-pending orders
    List<Order> findByWholesalerAndOrderStatus(Wholesaler wholesaler, String status);

    List<Order> findByManufacturer(Manufacturer manufacturer);

    List<Order> findByWholesaler(Wholesaler wholesaler);
    @Query("SELECT o FROM Order o JOIN FETCH o.manufacturer WHERE o.wholesaler = :wholesaler")
    List<Order> findByWholesalerWithManufacturer(@Param("wholesaler") Wholesaler wholesaler);

    @Query("SELECT DISTINCT o FROM Order o JOIN o.items i WHERE i.product.manufacturer = :manufacturer")
    List<Order> findOrdersByManufacturer(@Param("manufacturer") Manufacturer manufacturer);

    @Query("SELECT COUNT(o) FROM Order o")
    long countOrders();

    @Query("SELECT COALESCE(SUM(o.totalAmount), 0) FROM Order o")
    double calculateTotalRevenue();
    List<Order> findTop4ByOrderByOrderDateDesc();

    long countByManufacturerId(Long manufacturerId);
}