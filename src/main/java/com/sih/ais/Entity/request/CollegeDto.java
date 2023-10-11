package com.sih.ais.Entity.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CollegeDto {

    private Long collegeId;
    private String collegetype;
    private String collegedescription;
}