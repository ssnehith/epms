package io.riqueza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.riqueza.entity.Employee;
import io.riqueza.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
