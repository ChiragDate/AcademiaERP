package com.chirag.festaurant.academiaerp.Repository;

import com.chirag.festaurant.academiaerp.Entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryRepo extends JpaRepository<EmployeeSalary, Long> {

    List<EmployeeSalary> findByEmployeeId(Long employeeId);

}