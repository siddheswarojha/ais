package com.sih.ais.Entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int collegeId;

    public String collegeEmail;

    public String password;

    public String collegeType;
    public String collegeDescription;



}
