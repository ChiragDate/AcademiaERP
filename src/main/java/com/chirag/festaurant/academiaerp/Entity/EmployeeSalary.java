package com.chirag.festaurant.academiaerp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data // Lombok annotation for generating getters, setters, toString, equals, and hashCode
@Entity
@Table(name = "employee_salary")
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId; // Changed to Long as per request

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "description")
    private String description;
}