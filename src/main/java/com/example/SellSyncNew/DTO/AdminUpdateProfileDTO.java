package com.example.SellSyncNew.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateProfileDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
}
