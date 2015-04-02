package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    private String phoneNumber;
    private String email;
    private String birthday;

    private Company tenant;

    @Enumerated(EnumType.STRING)
    private Right[] rights;

    /*@OneToOne(mappedBy = "employee")
    private Account account;*/

    private boolean isDisabled;
}
