package com.example.SellSyncNew.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        String redirectURL = request.getContextPath();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            System.out.println("User Role: " + role);  // Log role

            if (role.equals("ROLE_ADMIN")) {
                redirectURL += "/admin/dashboard";
            } else if (role.equals("ROLE_MANUFACTURER")) {
                redirectURL += "/manufacturer/dashboard";
            } else if (role.equals("ROLE_WHOLESALER")) {
                redirectURL += "/wholesaler/dashboard";
            }
        }

        System.out.println("Redirecting to: " + redirectURL);  // Log redirection
        response.sendRedirect(redirectURL);
    }


}
