package com.git.gitpractice.DAO.impl;

import com.git.gitpractice.DAO.StudentDAO;
import com.git.gitpractice.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentDAOImpl implements StudentDAO {

    public EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student>result = entityManager.createQuery("FROM Student", Student.class);
        return result.getResultList();
    }

    @Override
    public Student findById(Integer id) {
        TypedQuery<Student>result = entityManager.createQuery("FROM Student WHERE id = :id",Student.class);
        result.setParameter("id",id);
        return result.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
