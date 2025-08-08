package com.example.SellSyncNew.Model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phone;
    private String organizationName;
    private String address;
    private String gstNumber;
    @Column(name = "company_name")
    private String companyName;

    private String status = "PENDING"; // Should be "PENDING", "APPROVED", etc.

    @Column(nullable = false)
    private boolean active = true;



}
