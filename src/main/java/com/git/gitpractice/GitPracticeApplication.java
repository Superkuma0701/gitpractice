package com.git.gitpractice;

import com.git.gitpractice.DAO.StudentDAO;
import com.git.gitpractice.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GitPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner ->{
//            createStudent(studentDAO);

//            createMultiStudents(studentDAO);

//            findAllStudent(studentDAO);

//            findById(studentDAO);

            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        //修改id = 5 的學生資料
        Integer id = 5;
        Student student = studentDAO.findById(id);
        student.setName("Cindy");
        student.setAge(55);
        studentDAO.updateStudent(student);
        System.out.println("update student success!");
    }

    private void findById(StudentDAO studentDAO) {
        Integer studentId = 6;
        Student student = studentDAO.findById(studentId);
        System.out.println("find by id :" + student.getId() + ", and detail:" + student);
    }

    private void findAllStudent(StudentDAO studentDAO) {
        List<Student>studentList = studentDAO.findAll();
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    private void createMultiStudents(StudentDAO studentDAO) {
        Student student = new Student("Ruru","ruru@gmail.com",18);
        Student student1 = new Student("Kevin","kevin@gmail.com",30);
        Student student2 = new Student("Amy","amy@gmail.com",28);

        studentDAO.save(student);
        studentDAO.save(student1);
        studentDAO.save(student2);

        System.out.println("create three students");

    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("Felix","felix@gmail.com",25);
        System.out.println("create a student ...");
        studentDAO.save(student);
        System.out.println("new student" + student.getId());
    }
}
