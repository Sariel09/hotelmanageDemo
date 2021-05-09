package com.demo.sariel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Date birth;
    private Integer departmentId;

//    public Employee(Integer id, String lastName, String email, Integer gender, String department,Date birth) {
//        this.id = id;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//        this.department = department;
//        this.birth = new Date();
//    }
}
