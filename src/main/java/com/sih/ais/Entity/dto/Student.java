package com.sih.ais.Entity.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    public String name;

    public String number;

    public String email;

    public String password;

    public Long Adhar_no;

}
/*dob
family income
current study
current  organisation
cast catagory
+

 */