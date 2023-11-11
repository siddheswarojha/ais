package com.sih.ais.service;


import com.sih.ais.Entity.request.StudentDto;

import java.util.List;

public interface IStudentService {

    String creatStudent(StudentDto StudentDto);
    String updateStudent(StudentDto studentDto,Long studentId);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();
    void deleteStudent(Long studentId);
}