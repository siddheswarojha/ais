package com.sih.ais.service;

import com.sih.ais.Entity.dto.User;
import com.sih.ais.Entity.request.AddUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    public String addUser(AddUserRequest userRequest);
    public void deleteAll();
    public List<User> getAllUserDetails();
}
