package com.example.SellSyncNew.Repository;


import com.example.SellSyncNew.Model.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler, Long> {
    List<Wholesaler> findByActiveTrue();
    List<Wholesaler> findByActiveFalse();

    Optional<Wholesaler> findByEmail(String email);
    Optional<Wholesaler> findById(Long id);
    long count();
    List<Wholesaler> findByStatus(String status);
}