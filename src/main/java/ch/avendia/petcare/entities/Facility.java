package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Facility extends BaseTenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany(targetEntity = Pet.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "FacilityPet", joinColumns = @JoinColumn(name = "Facility_ID"), inverseJoinColumns = @JoinColumn(name = "Pet_ID"))
    private Pet[] pets;

    @OneToMany(mappedBy = "facility")
    private ServiceReservation[] serviceReservations;

    @OneToMany(mappedBy = "facility")
    private ServiceExection[] serviceExections;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    @Enumerated(EnumType.STRING)
    private FacilityStatus facilityStatus;

    @ManyToOne
    private Invoice invoice;

}
