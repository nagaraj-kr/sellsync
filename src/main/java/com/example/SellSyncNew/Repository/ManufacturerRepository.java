package com.example.SellSyncNew.Repository;




import com.example.SellSyncNew.Model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findByActiveTrue();
    List<Manufacturer> findByActiveFalse();


    Optional<Manufacturer> findByEmail(String email);
    Optional<Manufacturer> findById(Long id);

    long count();
    List<Manufacturer> findByStatus(String status);




}
