package com.git.gitpractice.DAO;

import com.git.gitpractice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
