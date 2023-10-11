package com.sih.ais.service;


import com.sih.ais.Entity.dto.College;
import com.sih.ais.Entity.request.CollegeDto;
import com.sih.ais.Exception.ResourceNotFoundException;
import com.sih.ais.dao.CollegeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class    Collegeimple implements CollegeService {
    @Autowired
    private CollegeRepo collegeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CollegeDto createCollege(CollegeDto collegeDto) {
        College college = this.dtoToCollege(collegeDto);
        College savedCollege = this.collegeRepo.save(college);
        return this.collegeTODto(savedCollege);
    }

    @Override
    public CollegeDto updateCollege(CollegeDto collegeDto, Long collegeId) {
        College college = this.collegeRepo.findById(collegeId)
                .orElseThrow(()-> new ResourceNotFoundException("College","Id",collegeId));
        college.setCollegetype(collegeDto.getCollegetype());
        college.setCollegedescription(collegeDto.getCollegedescription());

        College updateCollege = this.collegeRepo.save(college);
        return this.collegeTODto(updateCollege);
    }

    @Override
    public CollegeDto getCollegeById(Long collegeId) {
        College college = this.collegeRepo.findById(collegeId)
                .orElseThrow(()-> new ResourceNotFoundException("College","Id",collegeId));
        return this.collegeTODto(college);
    }

    @Override
    public List<CollegeDto> getAllCollege() {
        List<College> colleges = this.collegeRepo.findAll();
        return colleges.stream().map(college -> this.collegeTODto(college)).collect(Collectors.toList());
    }

    @Override
    public void deleteCollege(Long collegeId) {
        College college = this.collegeRepo.findById(collegeId)
                .orElseThrow(()-> new ResourceNotFoundException("College","Id",collegeId));
        this.collegeRepo.delete(college);
    }

    @Override
    public void deleteAllCollege() {
        collegeRepo.deleteAll();

    }

    public College dtoToCollege(CollegeDto collegeDto){
        return this.modelMapper.map(collegeDto,College.class);
    }

    public CollegeDto collegeTODto(College college){
        return this.modelMapper.map(college,CollegeDto.class);
    }
}