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

    private String name;
    private String firstname;

    @Embedded
    private Address address;

    @Embedded
    private TelephoneNumber phoneNumber;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "owner")
    @OrderColumn
    private Pet[] pets;

    @OneToMany(mappedBy = "client")
    @OrderColumn
    private Facility[] facilities;

    @OneToMany(mappedBy = "client")
    @OrderColumn
    private Invoice[] invoices;

    @OneToMany(mappedBy = "client")
    @OrderColumn
    private Reservation[] reservations;
}
