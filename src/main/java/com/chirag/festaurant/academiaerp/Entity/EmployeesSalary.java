package com.chirag.festaurant.academiaerp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employees_salary")// Lombok annotation for generating getters, setters, toString, equals, and hashCode
public class EmployeesSalary {

    @Id// Auto-increment ID
    private Long id;

    @Column(name = "employee_Id", nullable = false)
    private Long employee_Id; // Changed to Long as per request


    private LocalDate paymentDate;

    @Column(nullable = false)
    private Long amount;

    private String description;
}