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
        String sql = "select * from Student where id = :id";
        Query<StudentEntity> query =
                sessionFactory
                        .getCurrentSession()
                        .createSQLQuery(sql)
                        .addEntity(StudentEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public List<StudentEntity> findAll() {
        String sql = "select * from Student";
        Query<StudentEntity> query =
                sessionFactory
                        .getCurrentSession()
                        .createSQLQuery(sql)
                        .addEntity(StudentEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(StudentEntity s) {
        sessionFactory.getCurrentSession().update(s);
    }
}
