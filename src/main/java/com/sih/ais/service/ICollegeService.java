package com.sih.ais.service;

import com.sih.ais.Entity.request.CollegeDto;

import java.util.List;

public interface ICollegeService {
    String createCollege(CollegeDto collegeDto);
    String updateCollegeDetails(CollegeDto collegeDto,Integer collegeId);
    CollegeDto getCollegeById(Integer collegeId);
    List<CollegeDto> getAllCollege();
    void deleteCollege(Integer collegeId);
}
