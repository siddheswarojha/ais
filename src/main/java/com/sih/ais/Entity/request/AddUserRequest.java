package com.sih.ais.Entity.request;

import com.sih.ais.Entity.dto.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class AddUserRequest {
   // public String userName;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String aadharNumber;

    public User ToEntity(User user){
        if(user==null){
            user = new User();
        }
        user.firstName= this.firstName;
        user.lastName=this.lastName;
        user.aadharNumber= this.aadharNumber;
        user.dateOfBirth=this.dateOfBirth;
        user.userName=firstName+""+lastName;

        return user;
    }
}
