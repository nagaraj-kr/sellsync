package com.example.SellSyncNew.Controller;

import com.example.SellSyncNew.DTO.PasswordChangeRequest;
import com.example.SellSyncNew.DTO.WholesalerDto;
import com.example.SellSyncNew.Service.WholesalerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@RequestMapping("/api/wholesaler")
public class WholesalerProfileController {

    @Autowired
    private WholesalerProfileService profileService;

    @GetMapping("/profile")
    public ResponseEntity<WholesalerDto> getProfile(Authentication authentication) {
        String email = authentication.getName();
        WholesalerDto profile = profileService.getWholesalerProfile(email);
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest request, Authentication authentication) {
        String email = authentication.getName();
        profileService.changePassword(email, request);
        return ResponseEntity.ok("Password changed successfully.");
    }
}