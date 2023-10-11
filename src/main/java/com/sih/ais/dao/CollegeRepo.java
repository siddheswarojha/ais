package com.sih.ais.dao;


import com.sih.ais.Entity.dto.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College,Long> {
}