package com.chirag.festaurant.academiaerp.Controller;

import com.chirag.festaurant.academiaerp.Service.SalaryService;
import com.chirag.festaurant.academiaerp.dto.DisburseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/salary")
public class SalaryController {

    private SalaryService salaryService;

    @PostMapping("/disburse")
    public ResponseEntity<String> disburseSalary(@RequestBody DisburseRequest request) {
        salaryService.disburseSalary(request);
        return ResponseEntity.ok("Salary disbursed successfully.");
    }
}

