package com.git.gitpractice.DAO;

import com.git.gitpractice.model.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    List<Student>findAll();

    Student findById(Integer id);

    void updateStudent(Student student) ;
}
