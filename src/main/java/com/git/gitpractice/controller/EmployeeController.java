package com.git.gitpractice.controller;

import com.git.gitpractice.DAO.EmployeeDAO;
import com.git.gitpractice.Exception.StudentNotFoundException;
import com.git.gitpractice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> employees(){
        return employeeDAO.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee employee(@PathVariable Integer employeeId){
        //find how many employees in the company first
        List<Employee> employeeList = employeeDAO.findAll();
        //check path variable whether under zero or out of number of employee list
        if(employeeId >= employeeList.size() || employeeId < 0 ){
            throw new StudentNotFoundException("can not found employee !");
        }

        return employeeDAO.findById(employeeId);
    }
}
