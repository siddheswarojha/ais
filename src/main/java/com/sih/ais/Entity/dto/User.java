package com.sih.ais.Entity.dto;

/*
@Author : Siddheswar
 */
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class User extends AbstractPersistable<Long> {

    public String userName;
    public String password;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String aadharNumber;

}
