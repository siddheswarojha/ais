package com.sih.ais.dao;


import com.sih.ais.Entity.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}