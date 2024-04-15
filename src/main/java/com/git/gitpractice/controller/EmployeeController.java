package com.git.gitpractice.controller;

import com.git.gitpractice.Exception.StudentNotFoundException;
import com.git.gitpractice.Service.EmployeeService;
import com.git.gitpractice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> employees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee employee(@PathVariable Integer employeeId){
        //find how many employees in the company first
        List<Employee> employeeList = employeeService.findAll();
        //check path variable whether under zero or out of number of employee list
        if(employeeId >= employeeList.size() || employeeId < 0 ){
            throw new StudentNotFoundException("can not found employee !");
        }

        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String  deleteEmployee(@PathVariable  Integer employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("employee id not found ! -" + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "delete employee by id success !";
    }
}
