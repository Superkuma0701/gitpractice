package com.git.gitpractice.Service.Impl;

import com.git.gitpractice.DAO.EmployeeRepository;
import com.git.gitpractice.Service.EmployeeService;
import com.git.gitpractice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee employee = null;
        if(result.isPresent()){
           employee = result.get();
        }else{
            throw  new RuntimeException(("Did not find the employeeId"));
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
