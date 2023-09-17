package com.sih.ais;

import com.sih.ais.Entity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}