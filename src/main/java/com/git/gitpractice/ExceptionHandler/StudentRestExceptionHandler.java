package com.git.gitpractice.ExceptionHandler;

import com.git.gitpractice.Exception.StudentNotFoundException;
import com.git.gitpractice.model.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class StudentRestExceptionHandler {
    //add exception handler here
    //exceptionHandler practice
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        Date date = new Date();
        error.setDate(date);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add another exception Handler to catch any exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse>handeException (Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        Date date = new Date();
        error.setDate(date);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
