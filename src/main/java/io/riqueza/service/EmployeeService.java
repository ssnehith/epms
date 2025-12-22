package io.riqueza.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public List<String> getEmployees() {
        return List.of("Alice", "Bob", "Charlie");
    }
}
