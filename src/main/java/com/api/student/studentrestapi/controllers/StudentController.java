package com.api.student.studentrestapi.controllers;

import com.api.student.studentrestapi.dao.StudentRepository;
import com.api.student.studentrestapi.model.Student;
import com.api.student.studentrestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAll()
    {
    	List list= studentService.getAll();
    	if(list.size()<=0)
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
        return ResponseEntity.of(Optional.of(list));
    }


    /**
     *
     * Get student by id handler
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id)
    {
        if(studentService.getStudentById(id)==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(studentService.getStudentById(id)));
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
    public ResponseEntity<Void> delete(@PathVariable("id") int id)
    {
    	if(studentService.getStudentById(id)==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    	else
    	{
    		studentService.delete(id);
    		ResponseEntity.status(HttpStatus.OK).build();
    	}
    	return null;
    }

//
//    /**
//     *
//     * student update handler
//     */
    @PutMapping("/update/{id}")
    public void update(@RequestBody Student student, @PathVariable("id") int id )
    {
        studentService.update(student, id);
    }

}



