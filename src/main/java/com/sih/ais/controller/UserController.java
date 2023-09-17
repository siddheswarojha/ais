package com.sih.ais.controller;

import com.sih.ais.Entity.dto.User;
import com.sih.ais.Entity.request.AddUserRequest;
import com.sih.ais.service.UserServices;
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
