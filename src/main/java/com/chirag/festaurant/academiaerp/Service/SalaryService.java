package com.chirag.festaurant.academiaerp.Service;

import com.chirag.festaurant.academiaerp.Entity.Employees;
import com.chirag.festaurant.academiaerp.Entity.EmployeesSalary;
import com.chirag.festaurant.academiaerp.Exception.EmployeeNotFoundException;
import com.chirag.festaurant.academiaerp.Helper.EncryptionService;
import com.chirag.festaurant.academiaerp.Helper.JWTHelper;
import com.chirag.festaurant.academiaerp.Repository.EmployeeRepo;
import com.chirag.festaurant.academiaerp.Repository.EmployeeSalaryRepo;
import com.chirag.festaurant.academiaerp.dto.DisburseRequest;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import com.chirag.festaurant.academiaerp.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeSalaryRepo salaryRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public void disburseSalary(DisburseRequest request) {
        Map<Long, Long> employeeSalaryMap = request.getEmployeeSalaryMap();
        String description = request.getDescription();
        String email = jwtHelper.extractEmail(request.getToken());

        Long loggedInEmployeeId = getEmployee(email).getEmployee_Id();

        if (employeeSalaryMap.containsKey(loggedInEmployeeId)) {
            throw new IllegalArgumentException("Logged-in employee cannot disburse salary to themselves.");
        }

        // Validate employee existence and remove logged-in employee
        Set<Long> validEmployeeIds = employeeSalaryMap.keySet().stream()
                .filter(id -> !id.equals(loggedInEmployeeId) && employeeRepo.existsById(id))
                .collect(Collectors.toSet());
        if (employeeSalaryMap.containsKey(loggedInEmployeeId)) {
            throw new IllegalArgumentException("Logged-in employee cannot disburse salary to themselves.");
        }

        if (validEmployeeIds.isEmpty()) {
            throw new RuntimeException("No valid employees to disburse salary to.");
        }

        // Process salary disbursement
        validEmployeeIds.forEach(employeeId -> {
            EmployeesSalary salary = new EmployeesSalary();
            salary.setEmployee_Id(employeeId);
            salary.setAmount(employeeSalaryMap.get(employeeId)); // Individual salary amount
            salary.setPaymentDate(LocalDate.now());
            salary.setDescription(description);
            salaryRepo.save(salary);
        });
    }

    public Employees getEmployee(String email) {
        return employeeRepo.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        format("Cannot find Employee:: No employee found with the provided email:: %s", email)
                ));
    }

    public String loginApi(LoginRequest request) {
        Employees employee = getEmployee(request.email());
        if (encryptionService.validatePassword(request.password(), employee.getPassword())) {
            return "Wrong Email or Password";
        }

        return jwtHelper.generateToken(request.email());
    }

    public List<EmployeeDTO> getEmployeesWithLastSalary() {
        try {
            // Directly fetch the DTO objects using the repository method
            List<EmployeeDTO> employeeDTOs = salaryRepo.findEmployeesWithLastDisbursedSalary();

            if (employeeDTOs.isEmpty()) {
                throw new RuntimeException("No employee salary data found");
            }

            return employeeDTOs;

        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee salary data: " + e.getMessage());
        }
    }
}
