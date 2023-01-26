package com.example.employee_manager.services;

import com.example.employee_manager.DTOs.EmployeeDTO;
import com.example.employee_manager.models.Employee;
import com.example.employee_manager.repos.EmployeeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeById(employeeDTO.id);
        if(employeeOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.firstName);
        employee.setLastName(employeeDTO.lastName);
        employee.setEmail(employeeDTO.email);
        employee.setJobTitle(employeeDTO.jobTitle);
        employee.setPhoneNumber(employeeDTO.phoneNumber);
        employee.setImageURL(employeeDTO.imageURL);
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeRepo.save(employee);
        return employee;
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeById(employeeDTO.id);
        if(employeeOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return employeeOptional.get();
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        employeeRepo.deleteById(id);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeById(employeeDTO.id);
        if(employeeOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Employee employee = employeeOptional.get();
        employee.setFirstName(employeeDTO.firstName);
        employee.setLastName(employeeDTO.lastName);
        employee.setEmail(employeeDTO.email);
        employee.setJobTitle(employeeDTO.jobTitle);
        employee.setPhoneNumber(employeeDTO.phoneNumber);
        employee.setImageURL(employeeDTO.imageURL);
        employeeRepo.save(employee);
    }
}
