package com.present.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.present.entity.Student;

public interface PresentRepository extends JpaRepository<Student, Integer> {

}
