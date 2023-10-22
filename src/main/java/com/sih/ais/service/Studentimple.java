package com.sih.ais.service;

import com.sih.ais.Entity.dto.Student;
import com.sih.ais.Entity.request.StudentDto;
import com.sih.ais.Exception.ResourceNotFoundException;
import com.sih.ais.dao.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class Studentimple implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto creatStudent(StudentDto studentDto) {
        Student student = this.dtoToStudent(studentDto);
        Student savedStudent = this.studentRepo.save(student);
        return this.studentToDto(savedStudent);
    }

    @Override
    public StudentDto updateUser(StudentDto studentDto , Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student","Id",studentId));
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setAdhar_no(Integer.parseInt(studentDto.getAdhar_no()));

        Student updateStudent = this.studentRepo.save(student);
        return this.studentToDto(updateStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",studentId));
        return this.studentToDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = this.studentRepo.findAll();
        return students.stream().map(student -> this.studentToDto(student)).collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student","Id",studentId));

        this.studentRepo.delete(student);
    }

    public void deleteAllStudents() {
        studentRepo.deleteAll();
    }

    public Student dtoToStudent(StudentDto studentDto){
        return this.modelMapper.map(studentDto,Student.class);
    }

    public StudentDto studentToDto(Student student){
        return this.modelMapper.map(student,StudentDto.class);
    }
}