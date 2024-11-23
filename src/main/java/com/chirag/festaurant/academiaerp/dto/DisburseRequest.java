package com.chirag.festaurant.academiaerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Data // Lombok to generate getters, setters, etc.
public class DisburseRequest {

        @NotNull(message = "Employee salary mapping cannot be null")
        @NotEmpty(message = "Employee salary mapping cannot be empty")
        @JsonProperty("employeeSalaryMap")
        private Map<Long, Long> employeeSalaryMap; // Map of employee_id -> salaryAmount

        @JsonProperty("description")
        private String description; // Optional field for additional remarks or comments

        private String token;
}
