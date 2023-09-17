package com.sih.ais.dao;

import com.sih.ais.Entity.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByAadharNumber(String AadharNumber);
}
