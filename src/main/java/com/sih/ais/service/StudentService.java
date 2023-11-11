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
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String creatStudent(StudentDto studentDto) {
        Student student = studentDto.ToEntity(null);
        studentRepo.save(student);
        if(student!=null)
        {
            return "success";
        }
        return "error";
    }

    @Override
    public String updateStudent(StudentDto studentDto , Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student","Id",studentId));
        if (student!=null) {
            student.setName(studentDto.getName());
            student.setEmail(studentDto.getEmail());
            student.setPassword(studentDto.getPassword());
            student.setAdhar_no(studentDto.getAdhar_no());

            Student updateStudent = this.studentRepo.save(student);
            return "success";
        }
        return "error";
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
        List<StudentDto> studentDtos = students.stream().map(this::studentToDto).collect(Collectors.toList());
        return studentDtos;
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


    public StudentDto studentToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPassword(student.getPassword());
        studentDto.setNumber(student.getNumber());
        studentDto.setAdhar_no(student.getAdhar_no());

        return studentDto;
    }
}