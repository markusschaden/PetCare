package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Employee extends BaseTenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;
    private String firstname;
    private String phoneNumber;
    private String email;
    private String birthday;

    @Enumerated(EnumType.STRING)
    private Right[] rights;

    @OneToOne(mappedBy = "employee")
    private Account account;

    private boolean isDisabled;
}
