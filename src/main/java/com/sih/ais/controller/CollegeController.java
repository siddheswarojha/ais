package com.sih.ais.controller;

import com.sih.ais.Entity.request.ApiResponse;
import com.sih.ais.Entity.request.CollegeDto;
import com.sih.ais.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ais/college")
public class CollegeController {

    @Autowired
    private ICollegeService IcollegeService;

    @PostMapping("/add/college")
    public String createCollege(@RequestBody CollegeDto collegeDto){
        return this.IcollegeService.createCollege(collegeDto);
    }

    @PutMapping("/update/{collegeId}")
    public String updateCollegeDetails(@RequestBody CollegeDto collegeDto,@PathVariable Integer collegeId){
        return this.IcollegeService.updateCollegeDetails(collegeDto,collegeId);
    }
    @GetMapping("/")
    public ResponseEntity<List<CollegeDto>> getAllCollege(){
        return ResponseEntity.ok(this.IcollegeService.getAllCollege());

    }
    @GetMapping("/{collegeId}")
    public CollegeDto getCollegeById(@PathVariable Integer collegeId){
        return IcollegeService.getCollegeById(collegeId);

    }
    @DeleteMapping("/{collegeId}")
    public ResponseEntity<ApiResponse> deleteCollege(@PathVariable Integer collegeId){
        this.IcollegeService.deleteCollege(collegeId);
        return new ResponseEntity<>(new ApiResponse("College deleted Successfully",true), HttpStatus.OK);
    }


}
