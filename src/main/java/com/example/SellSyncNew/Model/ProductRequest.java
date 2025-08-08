package com.example.SellSyncNew.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String category;
    private String manufacturer;
    private int quantity;
    private String specifications;
    private String deadline;
    private String status = "Pending"; // default status

    @ManyToOne
    @JoinColumn(name = "wholesaler_id")
    private Wholesaler wholesaler;
    // Getters and Setters

}

