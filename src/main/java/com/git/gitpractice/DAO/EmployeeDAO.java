package com.git.gitpractice.DAO;

import com.git.gitpractice.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Integer employeeId);
}
