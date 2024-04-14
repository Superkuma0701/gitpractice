package com.git.gitpractice.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentErrorResponse {

    private Integer status;
    private String message;
    private Date date;

    public StudentErrorResponse(Integer status, String message, Date date) {
        this.status = status;
        this.message = message;
        this.date = date;
    }

    public StudentErrorResponse() {
    }
}
