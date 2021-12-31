package com.api.student.studentrestapi.controllers;

import com.api.student.studentrestapi.model.Student;
import com.api.student.studentrestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class StudentController {

    /**
     * Getting object of Student bean from Spring IOC
     */
    @Autowired
    Student student;

    /**
     * Getting object of StudentService bean from Spring IOC
     */
    @Autowired
    StudentService studentService;

    /**
     * Get All students handler
     *
     */
    @GetMapping("/students")
    public List<Student> getAll()
    {
        return this.studentService.getAll();
    }


    /**
     *
     * Get student by id handler
     */
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id)
    {
        return this.studentService.getStudentById(id);
    }


    /**
     *
     * Create student handler
     */
    @PostMapping("/students")
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }


    /**
     *
     * Delete student handler
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id)
    {
     studentService.delete(id);
    }


    /**
     *
     * student update handler
     */
    @PutMapping("/update/{id}")
    public void update(@RequestBody Student student, @PathVariable("id") int id )
    {
        studentService.update(student, id);
    }

}



