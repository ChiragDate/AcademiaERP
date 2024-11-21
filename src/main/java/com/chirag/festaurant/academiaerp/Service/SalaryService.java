package com.chirag.festaurant.academiaerp.Service;

import com.chirag.festaurant.academiaerp.Entity.EmployeeSalary;
import com.chirag.festaurant.academiaerp.Repository.EmployeeRepo;
import com.chirag.festaurant.academiaerp.Repository.EmployeeSalaryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private EmployeeRepo employeeRepo;
    private EmployeeSalaryRepo salaryRepo;

    public void disburseSalary(List<Long> employeeIds, Long amount, String description) {
        List<EmployeeSalary> salaries = employeeIds.stream().map(id -> {
            EmployeeSalary salary = new EmployeeSalary();
            salary.setEmployeeId(id);
            salary.setAmount(amount);
            salary.setPaymentDate(new Date(System.currentTimeMillis()));
            salary.setDescription(description);
            return salary;
        }).collect(Collectors.toList());
        salaryRepo.saveAll(salaries);
    }
}