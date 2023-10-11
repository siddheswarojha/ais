package com.sih.ais.Entity.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private int id;
    private String name;
    private String email;
    private String password;
    private String Adhar_no;

}