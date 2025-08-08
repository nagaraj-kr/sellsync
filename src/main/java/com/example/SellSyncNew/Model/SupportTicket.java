package com.example.SellSyncNew.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String role; // "Manufacturer" or "Wholesaler"
    private String subject;
    private String orderId;
    @Column(length = 3000)
    private String message;
    private String imagePath;
    private String status = "Pending";

}
