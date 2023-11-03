package com.sih.ais.controller;


import com.sih.ais.Entity.request.ApiResponse;
import com.sih.ais.Entity.request.StudentDto;
import com.sih.ais.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ais/students")
public class StudentController{
    @Autowired
    private IStudentService IStudentService;

    @PostMapping("/add/student")
    public String createStudent(@RequestBody StudentDto studentDto) {
        return this.IStudentService.creatStudent(studentDto);
    }

    @PutMapping("/update/{studentId}")
    public String updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId)
    {
        return IStudentService.updateStudent(studentDto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("studentId") Long studentId)
    {
        this.IStudentService.deleteStudent(studentId);
        return new ResponseEntity<>(new ApiResponse("Student deleted Successfully", true),HttpStatus.OK);
    }



    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(this.IStudentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudentById(@PathVariable Long studentId) {
        return IStudentService.getStudentById(studentId);
    }


}