package com.chirag.festaurant.academiaerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

 // Lombok to generate getters, setters, and other utility methods

public record DisburseRequest (

        @JsonProperty("employeeIds")
     List<Long> employeeIds,// List of employee IDs to disburse salaries to
        @JsonProperty("amount")
     Long amount,// Salary amount to be disbursed
        @JsonProperty("description")
     String description,
        @JsonProperty("loggedInEmployeeId")
     Long loggedInEmployeeId// Optional description or remarks for the disbursement
 ){}

