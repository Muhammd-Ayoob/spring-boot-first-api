package com.api.student.studentrestapi.services;

import java.util.*;
import java.util.stream.Collectors;

import com.api.student.studentrestapi.dao.StudentRepository;
import com.api.student.studentrestapi.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	
	@Autowired
	StudentRepository repository;

//    static List<Student> list = new ArrayList();
//
//    static {
//
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Muqeet");
//        student.setRollNo("18CS81");
//        list.add(student);
//
//        Student student1 = new Student();
//        student1.setId(2);
//        student1.setName("Ayoob");
//        student1.setRollNo("18CS85");
//        list.add(student1);
//
//        Student student2 = new Student();
//        student2.setId(3);
//        student2.setName("Ramesh");
//        student2.setRollNo("18CS87");
//        list.add(student2);
//    }


    public List<Student> getAll() {
    	
    	List<Student> list = (List)repository.findAll();
    	
        return list;
    }


    public Student getStudentById(int id) {
    	Student student1=null;
       try {
    	   
    	  Optional<Student> optional = repository.findById(id);
    	  student1 = optional.get();
       
    	 // student1 = list.stream().filter(student -> student.getId() == id).findFirst().get();
       }
       catch(Exception exception)
       {
    	   exception.printStackTrace();
       }
       return student1;
    }


    public void addStudent(Student student)
    {
       
    	repository.save(student);
    }



    public void delete(int id)
    {
    	
        repository.deleteById(id);
    	
    }


    public void update(Student student, int id)
    {
     student.setId(id);  
       repository.save(student);
    }
}