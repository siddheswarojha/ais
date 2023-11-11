package com.sih.ais.Entity.request;

import com.sih.ais.Entity.dto.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    public int id;
    public String name;
    public String email;
    public String password;
    public Long Adhar_no;
    public String number;


    public Student ToEntity(Student student){
        if (student == null){
            student = new Student();
        }
        student.name=this.name;
        student.email=this.email;
        student.password=this.password;
        student.Adhar_no=this.Adhar_no;
        student.number=this.number;


        return student;
    }
}