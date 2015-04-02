package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Client extends Account {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    private String name;
    private String firstname;

    @Embedded
    private Address address;

    private String phoneNumber;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    /*@OneToOne(mappedBy = "client")
    private Account account;*/

    @OneToMany(mappedBy = "owner")
    private Pet[] pets;

    @OneToMany(mappedBy = "client")
    private Facility[] facilities;

    @OneToMany(mappedBy = "client")
    private Invoice[] invoices;

    @OneToMany(mappedBy = "client")
    private Reservation[] reservations;
}
