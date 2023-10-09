package com.sih.ais.service;

import com.sih.ais.Entity.dto.User;
import com.sih.ais.Entity.request.AddUserRequest;
import com.sih.ais.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public String addUser(AddUserRequest userRequest) {
        User user = userRequest.ToEntity(null);
        userRepository.save(user);
        if(user!=null)
        {
            return "success";
        }
        return "error";
    }

  /*  {
        firstName : "sid",
        lastname: "ojha"
    }*/

}
