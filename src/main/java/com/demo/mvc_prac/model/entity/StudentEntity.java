package com.demo.mvc_prac.model.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "math_score")
    private Integer mathScore;
}
