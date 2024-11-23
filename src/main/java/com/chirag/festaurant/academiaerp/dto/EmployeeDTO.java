package com.chirag.festaurant.academiaerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeDTO {
    @JsonProperty("employee_Id")
    private Long employee_id;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("department")
    private String department;

    @JsonProperty("title")
    private String title;

    @JsonProperty("amount")
    private Long amount;

    // Constructor
    public EmployeeDTO(Long employee_id, String first_name, String last_name, String email,
                       String department, String title, Long amount) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.department = department;
        this.title = title;
        this.amount = amount;
    }

    // Add default constructor
    public EmployeeDTO() {
    }
}