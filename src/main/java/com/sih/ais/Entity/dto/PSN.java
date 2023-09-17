package com.sih.ais.Entity.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PSN extends AbstractPersistable<Long> {
    private String PSN;
    private String AadharNumber;
    private String HighestQualification;
}
