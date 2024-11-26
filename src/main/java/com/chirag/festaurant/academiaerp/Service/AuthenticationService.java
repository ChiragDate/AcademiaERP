package com.chirag.festaurant.academiaerp.Service;

import com.chirag.festaurant.academiaerp.Helper.JWTHelper;
import com.chirag.festaurant.academiaerp.Repository.EmployeeRepo;
import com.chirag.festaurant.academiaerp.Entity.Employees;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private JWTHelper jwtHelper;
    private final EmployeeRepo emprepo;

    public String getCurrentJwtToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getCredentials() != null) {
            return authentication.getCredentials().toString();
        }

        return null;
    }

    public Long getCurrentEmployeeId() {
        try {
            // Extract email from the current JWT token
            String token = getCurrentJwtToken();
            if (token == null) {
                return null;
            }

            // Remove "Bearer " prefix if present
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            // Extract email from token
            String email = jwtHelper.extractEmail(token);

            // Find employee by email
            Employees employee = emprepo.findEmployeeByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            return employee.getEmployee_Id();
        } catch (Exception e) {
            // Log the error or handle it appropriately
            return null;
        }
    }

}
