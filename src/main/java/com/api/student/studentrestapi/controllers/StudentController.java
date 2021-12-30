package com.api.student.studentrestapi.controllers;

import com.api.student.studentrestapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class StudentController {

    @Autowired
    Student student;

    @GetMapping("/student")


    @Bean
    public Student getString()
    {
        student.setId(1);
        student.setName("Ayaz");
        student.setRollNo("18CS85");

        return student;
    }
}
