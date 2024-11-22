package com.chirag.festaurant.academiaerp.Controller;

import com.chirag.festaurant.academiaerp.dto.DisburseRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    @PostMapping("/disburse")
    public String disburseSalaries(@RequestBody DisburseRequest request) {
        Map<Long, Long> employeeSalaryMap = request.getEmployeeSalaryMap();
        Long loggedInEmployeeId = request.getLoggedInEmployeeId();

        if (employeeSalaryMap.containsKey(loggedInEmployeeId)) {
            throw new IllegalArgumentException("Logged-in employee cannot disburse salary to themselves.");
        }

        // Perform salary disbursement logic here
        // Save transaction in database, etc.

        return "Salaries disbursed successfully.";
    }
}
