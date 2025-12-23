package io.riqueza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.riqueza.dto.CreateEmployeeRequest;
import io.riqueza.dto.UpdateEmployeeRequest;
import io.riqueza.entity.Employee;
import io.riqueza.exception.ResourceNotFoundException;
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

    public Employee createEmployee(CreateEmployeeRequest req) {
    Employee emp = new Employee(req.getName(), req.getEmail(), req.getDepartment(), req.getBaseSalary());
    return employeeRepository.save(emp);
    }

    public Employee updateEmployee(Long id, UpdateEmployeeRequest req) {
    Employee emp = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

    emp.setName(req.getName());
    emp.setEmail(req.getEmail());
    emp.setDepartment(req.getDepartment());
    emp.setBaseSalary(req.getBaseSalary());

    return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(emp);
    }


}
