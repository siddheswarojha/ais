package com.sih.ais.service;

import com.sih.ais.Entity.dto.PSN;
import com.sih.ais.Entity.dto.User;
import com.sih.ais.dao.PSNRepository;
import com.sih.ais.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PSNServices implements IPSNServices{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PSNRepository psnRepository;
    @Override
    public String GeneratePSN(String aadharNumber) {

        User user = userRepository.findUserByAadharNumber(aadharNumber);
        if (user == null){
            return "error";
        }
        PSN psn = new PSN();
        psn.setAadharNumber(aadharNumber);
        psn.setHighestQualification("xyz"); //initiating with dummy
        String newPSN = user.aadharNumber+ user.firstName+ user.dateOfBirth; //initiating with dummy
        psn.setPSN(newPSN);
        psnRepository.save(psn);
        return "success";
    }
}
