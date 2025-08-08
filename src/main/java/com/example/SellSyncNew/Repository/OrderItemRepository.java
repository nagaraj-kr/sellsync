package com.example.SellSyncNew.Repository;

import com.example.SellSyncNew.Model.Manufacturer;
import com.example.SellSyncNew.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByProduct_Manufacturer(Manufacturer manufacturer);
}
