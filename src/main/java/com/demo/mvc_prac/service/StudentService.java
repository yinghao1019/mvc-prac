package com.demo.mvc_prac.service;

import com.demo.mvc_prac.model.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findStudent();
    StudentEntity findStudent(long id);
    void updateStudent(StudentEntity s);
}
