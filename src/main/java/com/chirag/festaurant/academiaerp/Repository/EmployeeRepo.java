package com.chirag.festaurant.academiaerp.Repository;

import com.chirag.festaurant.academiaerp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    List<Employee> findByDepartmentNot(String department);
}
