package com.git.gitpractice.DAO;

import com.git.gitpractice.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student>findByName(String name);

}
