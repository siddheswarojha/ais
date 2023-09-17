package com.sih.ais;

import com.sih.ais.Entity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ais/user/")
public class UserController {

    @Autowired
    UserServices userServices;   // UserServices userServices = new UserServices
    @GetMapping("list/user")
    public List<User> GetAllUserDetails(){
        return userServices.getAllUserDetails();
    }

    @DeleteMapping("delete/all/user")
    public void deleteUser(){
        userServices.deleteAll();
    }
    @PostMapping("add/user")
    public String AddUser(AddUserRequest userRequest){
     return userServices.addUser(userRequest);
    }




}
