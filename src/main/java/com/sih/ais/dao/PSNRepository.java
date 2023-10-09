package com.sih.ais.dao;

import com.sih.ais.Entity.dto.PSN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PSNRepository extends JpaRepository<PSN,Long> {
   // PSN findPSNByAadharNumber(String aadharNumber);
}
