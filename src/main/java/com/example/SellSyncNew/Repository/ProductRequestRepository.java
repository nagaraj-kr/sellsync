package com.example.SellSyncNew.Repository;

import com.example.SellSyncNew.Model.ProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRequestRepository extends JpaRepository<ProductRequest, Long> {
    List<ProductRequest> findByWholesalerId(Long wholesalerId);
}