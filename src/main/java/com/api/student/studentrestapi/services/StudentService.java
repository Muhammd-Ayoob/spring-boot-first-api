package com.api.student.studentrestapi.services;

import java.util.*;
import java.util.stream.Collectors;

import com.api.student.studentrestapi.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    static List<Student> list = new ArrayList();

    static {

        Student student = new Student();
        student.setId(1);
        student.setName("Muqeet");
        student.setRollNo("18CS81");
        list.add(student);

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("Ayoob");
        student1.setRollNo("18CS85");
        list.add(student1);

        Student student2 = new Student();
        student2.setId(3);
        student2.setName("Ramesh");
        student2.setRollNo("18CS87");
        list.add(student2);
    }


    public List<Student> getAll() {
        return list;
    }


    public Student getStudentById(int id) {
        System.out.println(list);
        return list.stream().filter(student -> student.getId() == id).findFirst().get();


    }


    public void addStudent(Student student)
    {
        list.add(student);
    }



    public void delete(int id)
    {
        list = list.stream().filter(student1 -> (student1.getId()!= id)).collect(Collectors.toList());
    }


    public void update(Student student, int id)
    {
        list.stream().map(student1 -> {
            if(student1.getId() == id)
            {
                student1.setName(student.getName());
                student1.setRollNo(student.getRollNo());
            }
            return student;
        }).collect(Collectors.toList());
    }
}