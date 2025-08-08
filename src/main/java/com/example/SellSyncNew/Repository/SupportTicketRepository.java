package com.example.SellSyncNew.Repository;

import com.example.SellSyncNew.Model.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    List<SupportTicket> findByUsernameIgnoreCaseAndRoleIgnoreCase(String username, String role);

}