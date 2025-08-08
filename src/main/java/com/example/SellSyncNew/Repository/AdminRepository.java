package com.example.SellSyncNew.Repository;




import com.example.SellSyncNew.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);
    Optional<Admin> findById(Long id);
    List<Admin> findByStatus(String status);
}

