package com.example.SellSyncNew.Service;

import com.example.SellSyncNew.DTO.ManufacturerDto;
import com.example.SellSyncNew.DTO.PasswordChangeRequest;
import com.example.SellSyncNew.Model.Manufacturer;
import com.example.SellSyncNew.Repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerProfileService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ManufacturerDto getManufacturerProfile(String email) {
        Manufacturer manufacturer = manufacturerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));

        ManufacturerDto dto = new ManufacturerDto();
        dto.setEmail(manufacturer.getEmail());
        dto.setOrganizationName(manufacturer.getOrganizationName());
        dto.setAddress(manufacturer.getAddress());
        dto.setGstNumber(manufacturer.getGstNumber());
        dto.setPhone(manufacturer.getPhone());
        // Do not set password in response DTOs (security best practice)
        return dto;
    }

    public void changePassword(String email, PasswordChangeRequest request) {
        Manufacturer manufacturer = manufacturerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Manufacturer not found"));

        if (!passwordEncoder.matches(request.getCurrentPassword(), manufacturer.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }

        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("New password and confirmation do not match");
        }

        manufacturer.setPassword(passwordEncoder.encode(request.getNewPassword()));
        manufacturerRepository.save(manufacturer);
    }
}
