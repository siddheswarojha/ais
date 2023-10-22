package com.sih.ais.service;


import com.sih.ais.Entity.request.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto creatStudent(StudentDto StudentDto);
    StudentDto updateUser(StudentDto studentDto,Long studentId);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();
    void deleteStudent(Long studentId);

    void deleteAllStudents();
}