package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Employee extends Account {

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;
    private String firstname;
    @Embedded
    private TelephoneNumber phoneNumber;
    private String email;
    private String birthday;

    private Company tenant;

    @Enumerated(EnumType.STRING)
    private Permission permission;

    private boolean isDisabled;
}
