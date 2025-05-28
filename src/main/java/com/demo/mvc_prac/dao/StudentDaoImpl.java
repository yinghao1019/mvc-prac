package com.demo.mvc_prac.dao;

import com.demo.mvc_prac.model.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private final SessionFactory sessionFactory;

    @Override
    @Transactional
    public StudentEntity findById(long id) {
        String hql = "from StudentEntity where id = :id";
        Query<StudentEntity> query =
                sessionFactory
                        .getCurrentSession()
                        .createQuery(hql, StudentEntity.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    @Override
    @Transactional
    public List<StudentEntity> findAll() {
        String hql = "from StudentEntity";
        Query<StudentEntity> query =
                sessionFactory
                        .getCurrentSession()
                        .createQuery(hql, StudentEntity.class);
        return query.list();
    }

    @Override
    @Transactional
    public void update(StudentEntity s) {
        sessionFactory.getCurrentSession().update(s);
    }
}
