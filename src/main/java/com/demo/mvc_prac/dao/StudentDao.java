package com.demo.mvc_prac.dao;

import com.demo.mvc_prac.model.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    StudentEntity findById(long id);
    List<StudentEntity> findAll();
    void update(StudentEntity s);
}
