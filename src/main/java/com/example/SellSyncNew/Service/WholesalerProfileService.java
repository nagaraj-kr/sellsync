package com.example.SellSyncNew.Service;

import com.example.SellSyncNew.DTO.PasswordChangeRequest;

import com.example.SellSyncNew.DTO.WholesalerDto;
import com.example.SellSyncNew.Model.Wholesaler;
import com.example.SellSyncNew.Repository.WholesalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class WholesalerProfileService {

    @Autowired
    private WholesalerRepository wholesalerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public WholesalerDto getWholesalerProfile(String email) {
        Wholesaler wholesaler = wholesalerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Wholesaler not found"));

        WholesalerDto dto = new WholesalerDto();
        dto.setEmail(wholesaler.getEmail());
        dto.setOrganizationName(wholesaler.getOrganizationName());
        dto.setAddress(wholesaler.getAddress());
        dto.setGstNumber(wholesaler.getGstNumber());
        dto.setPhone(wholesaler.getPhone());
        return dto;
    }

    public void changePassword(String email, PasswordChangeRequest request) {
        Wholesaler wholesaler = wholesalerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Wholesaler not found"));

        if (!passwordEncoder.matches(request.getCurrentPassword(), wholesaler.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }

        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("New password and confirmation do not match");
        }

        wholesaler.setPassword(passwordEncoder.encode(request.getNewPassword()));
        wholesalerRepository.save(wholesaler);
    }
}