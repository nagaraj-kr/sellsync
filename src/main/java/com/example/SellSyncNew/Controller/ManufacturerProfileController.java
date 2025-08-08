package com.example.SellSyncNew.Controller;

import com.example.SellSyncNew.DTO.ManufacturerDto;
import com.example.SellSyncNew.DTO.OrderDTO;
import com.example.SellSyncNew.DTO.PasswordChangeRequest;
import com.example.SellSyncNew.Service.ManufacturerProfileService;
import com.example.SellSyncNew.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerProfileController {

    @Autowired
    private ManufacturerProfileService profileService;
    @Autowired
    private OrderService orderService;

    // Get profile of the currently authenticated manufacturer
    @GetMapping("/profile")
    public ResponseEntity<ManufacturerDto> getProfile(Authentication authentication) {
        String email = authentication.getName(); // Logged-in user's email
        ManufacturerDto profile = profileService.getManufacturerProfile(email);
        return ResponseEntity.ok(profile);
    }

    // Change password for the currently authenticated manufacturer
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest request, Authentication authentication) {
        String email = authentication.getName(); // Logged-in user's email
        profileService.changePassword(email, request);
        return ResponseEntity.ok("Password changed successfully.");
    }
    @GetMapping("/dashboardsummary")
    public ResponseEntity<Map<String, Object>> getDashboardSummary(Authentication authentication) {
        String email = authentication.getName();
        List<OrderDTO> orders = orderService.getOrdersByManufacturerEmail(email);

        int totalOrders = orders.size();
        double totalRevenue = orders.stream()
                .filter(order -> !"canceled".equalsIgnoreCase(order.getOrderStatus()))
                .mapToDouble(OrderDTO::getTotalAmount)
                .sum();

        Map<String, Object> response = new HashMap<>();
        response.put("totalOrders", totalOrders);
        response.put("totalRevenue", totalRevenue);
        System.out.println(totalOrders);
        System.out.println(totalRevenue);

        return ResponseEntity.ok(response);
    }

}
