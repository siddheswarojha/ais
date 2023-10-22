package com.sih.ais.service;



import com.sih.ais.Entity.request.CollegeDto;

import java.util.List;

public interface CollegeService {

    CollegeDto createCollege(CollegeDto collegeDto);
    CollegeDto updateCollege(CollegeDto collegeDto,Long collegeId);
    CollegeDto getCollegeById(Long collegeId);
    List<CollegeDto> getAllCollege();
    void deleteCollege(Long collegeId);
    void deleteAllCollege();
}