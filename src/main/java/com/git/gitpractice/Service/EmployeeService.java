package com.git.gitpractice.Service;

import com.git.gitpractice.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>findAll();

    Employee findById(Integer employeeId);

    Employee save(Employee employee);

    void deleteById(Integer employeeId);
}
