package com.example.SellSyncNew.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "redirect:/admindashboard.html";
    }

    @GetMapping("/manufacturer/dashboard")
    public String manufacturerDashboard() {
        return "redirect:/manufacturerdashboard.html";
    }

    @GetMapping("/wholesaler/dashboard")
    public String wholesalerDashboard() {
        return "redirect:/wholesalerdashboard.html";
    }
}
