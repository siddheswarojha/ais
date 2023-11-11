package com.sih.ais.service;

import com.sih.ais.Entity.dto.College;
import com.sih.ais.Entity.request.CollegeDto;
import com.sih.ais.Exception.ResourceNotFoundException;
import com.sih.ais.dao.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeService implements ICollegeService {

    @Autowired
    private CollegeRepo collegeRepo;
    @Override
    public String createCollege(CollegeDto collegeDto) {
        College college = collegeDto.ToEntity(null);
        collegeRepo.save(college);
        if (college!=null){
            return "success";
        }
        return "error";
    }

    @Override
    public String updateCollegeDetails(CollegeDto collegeDto, Integer collegeId) {
        College college =this.collegeRepo.findById(collegeId).orElseThrow(()-> new ResourceNotFoundException("College","CollegeId",collegeId));
        if (college!=null){
            college.setCollegeEmail(collegeDto.getCollegeEmail());
            college.setCollegeType(collegeDto.getCollegeType());
            college.setPassword(collegeDto.getPassword());
            college.setCollegeDescription(collegeDto.getCollegeDescription());
            College save = collegeRepo.save(college);

            return "success";
        }
        return "error";
    }

    @Override
    public CollegeDto getCollegeById(Integer collegeId) {
        College college = this.collegeRepo.findById(collegeId).orElseThrow(()-> new ResourceNotFoundException("College","CollegeID",collegeId));

        return this.collegeToDto(college);
    }

    @Override
    public List<CollegeDto> getAllCollege() {
        List<College> students = this.collegeRepo.findAll();
        return students.stream().map(this::collegeToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCollege(Integer collegeId) {
        College college = this.collegeRepo.findById(collegeId).orElseThrow(()-> new ResourceNotFoundException("College","CollegeID",collegeId));

        this.collegeRepo.delete(college);

    }

    public CollegeDto collegeToDto(College college){
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setCollegeEmail(college.getCollegeEmail());
        collegeDto.setCollegeId(college.getCollegeId());
        collegeDto.setCollegeType(college.getCollegeType());
        collegeDto.setCollegeDescription(college.getCollegeDescription());

        return collegeDto;

    }


}

