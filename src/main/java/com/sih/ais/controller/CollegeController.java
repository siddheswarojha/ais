package com.sih.ais.controller;



import com.sih.ais.Entity.request.ApiResponse;
import com.sih.ais.Entity.request.CollegeDto;
import com.sih.ais.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asi/colleges/")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping("/")
    public ResponseEntity<CollegeDto> createCollege(@RequestBody CollegeDto collegeDto){
        CollegeDto createCollegeDto = this.collegeService.createCollege(collegeDto);
        return  new ResponseEntity<>(createCollegeDto, HttpStatus.CREATED);
    }

    @PutMapping("/{collegeId}")
    public ResponseEntity<CollegeDto> updateCollege(@RequestBody CollegeDto collegeDto,@PathVariable Long collegeId){
        CollegeDto updateCollege = this.collegeService.updateCollege(collegeDto,collegeId);
        return ResponseEntity.ok(updateCollege);
    }

    @DeleteMapping("/{collegeId}")
    public ResponseEntity<ApiResponse> deleteCollege(@PathVariable ("collegeId") Long collegeId){
        this.collegeService.deleteCollege(collegeId);
        return new ResponseEntity<>(new ApiResponse("College Deleted Successfully",true),HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteAllColleges(){
        this.collegeService.deleteAllCollege();
        return new ResponseEntity<>(new ApiResponse("All Colleges Deleteed",true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CollegeDto>> getAllCollege(){
        return ResponseEntity.ok(this.collegeService.getAllCollege());
    }

    @GetMapping("/{collegeId}")
    public ResponseEntity<CollegeDto> getSingleCollege(@PathVariable Long collegeId){
        return ResponseEntity.ok(this.collegeService.getCollegeById(collegeId));
    }
}