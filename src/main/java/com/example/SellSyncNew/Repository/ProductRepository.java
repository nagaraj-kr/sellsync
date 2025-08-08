package com.example.SellSyncNew.Repository;


import com.example.SellSyncNew.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByManufacturerId(Long manufacturerId);
    List<Product> findByManufacturerIdAndStatusIgnoreCase(Long manufacturerId, String status);

    List<Product> findByStatus(String status);
    List<Product> findByManufacturerIdAndStatus(Long manufacturerId, String status);
    long count();
    long countByManufacturerId(Long manufacturerId);

}
