package com.chirag.festaurant.academiaerp.Repository;

import com.chirag.festaurant.academiaerp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findEmployeeByEmail(String email);
}
