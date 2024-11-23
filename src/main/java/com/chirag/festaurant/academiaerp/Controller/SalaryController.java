package com.chirag.festaurant.academiaerp.Controller;

import com.chirag.festaurant.academiaerp.Service.SalaryService;
import com.chirag.festaurant.academiaerp.dto.DisburseRequest;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;
    @PostMapping("/disburse")
    public ResponseEntity<String> disburseSalaries(@RequestBody DisburseRequest request) {

        salaryService.disburseSalary(request);
        return ResponseEntity.ok("Salaries disbursed successfully.");

    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeDetailsWithLastSalary() {
        System.out.println("GET employees details called");
        // Call service to fetch employee details and their last disbursed salary
        return ResponseEntity.ok(salaryService.getEmployeesWithLastSalary());
    }


}
