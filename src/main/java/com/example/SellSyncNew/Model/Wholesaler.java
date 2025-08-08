package com.example.SellSyncNew.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wholesaler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String email;
    private String password;
    private String organizationName;
    private String address;
    private String gstNumber;

    @OneToMany(mappedBy = "wholesaler", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductRequest> requests;

    private String status= "PENDING"; // Should be "PENDING", "APPROVED", etc.
    @Column(nullable = false)
    private boolean active = true;

}
