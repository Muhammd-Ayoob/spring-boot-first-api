package com.api.student.studentrestapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.student.studentrestapi.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{


}
