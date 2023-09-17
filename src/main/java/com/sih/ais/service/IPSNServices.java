package com.sih.ais.service;

import org.springframework.stereotype.Service;

@Service
public interface IPSNServices {
    public String GeneratePSN(String AadharNumber);
}
