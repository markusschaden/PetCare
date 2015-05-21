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
public class Pet extends DatabaseEntity {

    @ManyToOne
    private Animal animal;

    private String species;

    private String name;

    @ManyToOne
    private Client owner;

    @OneToMany(mappedBy="pet")
    @OrderColumn
    private PetPicture[] pictures;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @OneToMany(mappedBy="pet")
    @OrderColumn
    private Vaccination[] vaccinations;

    @OneToMany(mappedBy="pet")
    @OrderColumn
    private Allergie[] allergies;

    @OneToMany(mappedBy="pet")
    @OrderColumn
    private Food[] food;

    private String additionalInformation;

    private boolean disabled;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "pets",
            targetEntity = Facility.class
    )
    @OrderColumn
    private Facility[] facilities;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "pets",
            targetEntity = Reservation.class
    )
    @OrderColumn
    private Reservation[] reservations;


}
