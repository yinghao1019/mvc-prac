package com.demo.mvc_prac.service;

import com.demo.mvc_prac.dao.StudentDao;
import com.demo.mvc_prac.model.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao dao;

    @Override
    @Transactional
    public List<StudentEntity> findStudent() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public StudentEntity findStudent(long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void updateStudent(StudentEntity s) {
        dao.update(s);
    }
}
