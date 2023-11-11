package com.sih.ais.Entity.request;

import com.sih.ais.Entity.dto.College;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeDto {
    public int collegeId;
    public String collegeEmail;
    public String password;
    public String collegeType;
    public String collegeDescription;

    public College ToEntity(College college){
        if (college==null){
            college = new College();
        }
        college.collegeId=this.collegeId;
        college.collegeEmail=this.collegeEmail;
        college.password=this.password;
        college.collegeType=this.collegeType;
        college.collegeDescription=this.collegeDescription;

        return college;

    }

}
