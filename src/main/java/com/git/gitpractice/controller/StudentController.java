package com.git.gitpractice.controller;

import com.git.gitpractice.DAO.StudentRepository;
import com.git.gitpractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);
        return "執行資料庫的Create操作";
    }

    @PutMapping("/student/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        //一定要先查詢讓jpa去找有沒有重複的值
        Student s = studentRepository.findById(studentId).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            studentRepository.save(s);
            return "執行update動作";
        } else {
            return "執行update失敗";
        }

    }

    @DeleteMapping("/student/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        studentRepository.deleteById(studentId);
        return "執行delete操作";
    }

    @GetMapping("/student/{studentId}")
    public Student read(@PathVariable Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @GetMapping("/students/{studentName}")
    public List<Student> readName(@PathVariable String studentName) {
        return studentRepository.findByName(studentName);
    }
}
