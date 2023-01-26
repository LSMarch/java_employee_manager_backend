package com.example.employee_manager.repos;

import com.example.employee_manager.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(Optional<Long> id);
}
