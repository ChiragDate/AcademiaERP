package com.chirag.festaurant.academiaerp.Service;

import com.chirag.festaurant.academiaerp.Entity.Employee;
import com.chirag.festaurant.academiaerp.Entity.EmployeeSalary;
import com.chirag.festaurant.academiaerp.Repository.EmployeeRepo;
import com.chirag.festaurant.academiaerp.Repository.EmployeeSalaryRepo;
import com.chirag.festaurant.academiaerp.dto.DisburseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private EmployeeRepo employeeRepo;
    private EmployeeSalaryRepo salaryRepo;

    public void disburseSalary(DisburseRequest request) {

        List<Long> employeeIds = request.employeeIds();
         Long amount = request.amount();
         String description = request.description();
         Long loggedInEmployeeId = request.loggedInEmployeeId();
         List<Long> validEmployeeIds = employeeIds.stream()
                .filter(id -> !id.equals(loggedInEmployeeId))
                .toList();

        if (validEmployeeIds.isEmpty()) {
            throw new RuntimeException("No valid employees to disburse salary to.");
        }

        // Process the salary disbursement
        validEmployeeIds.forEach(employeeId -> {
            EmployeeSalary salary = new EmployeeSalary();
            salary.setEmployeeId(employeeId);
            salary.setAmount(amount);
            salary.setPaymentDate(LocalDate.now());
            salary.setDescription(description);
            salaryRepo.save(salary);
        });
    }

}