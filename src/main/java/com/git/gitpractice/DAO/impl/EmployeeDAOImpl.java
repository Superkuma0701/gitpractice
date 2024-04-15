package com.git.gitpractice.DAO.impl;

import com.git.gitpractice.DAO.EmployeeDAO;
import com.git.gitpractice.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> result = entityManager.createQuery("FROM Employee ", Employee.class);

        return result.getResultList();

    }

    @Override
    public Employee findById(Integer employeeId) {
        TypedQuery<Employee> result = entityManager.createQuery("FROM Employee WHERE id = :id",Employee.class);
        result.setParameter("id" , employeeId);
        return result.getSingleResult();
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        //if id == 0 -> insert an employee or update employee
        return dbEmployee;
    }

    @Override
    public void deleteById(Integer employeeId) {
        //find employee by id
        Employee employee = entityManager.find(Employee.class , employeeId);
        //remove employee
        entityManager.remove(employee);
    }
}
