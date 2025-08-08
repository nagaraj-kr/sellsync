package com.example.SellSyncNew.Config;

import com.example.SellSyncNew.Model.Admin;
import com.example.SellSyncNew.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class AdminInitializer {
    @Autowired
    AdminRepository adminRepository;
    @Bean
    public CommandLineRunner initAdmin(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (adminRepository.count() == 0) {
                Admin admin = new Admin();
                admin.setUsername("admin");
                admin.setPhone("9999999999");
                admin.setEmail("admin@sellsync.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setStatus("APPROVED");
                adminRepository.save(admin);
                System.out.println("✅ Default admin user created.");
            } else {
                System.out.println("ℹ️ Admin already exists. Skipping creation.");
            }
        };
    }
}
