package com.git.gitpractice.model;

import lombok.Data;

@Data
public class StudentPOJO {
    public String firstName;
    public String lastName;

    public StudentPOJO() {
    }

    public StudentPOJO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
