package io.riqueza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.riqueza.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // no code needed now
}
