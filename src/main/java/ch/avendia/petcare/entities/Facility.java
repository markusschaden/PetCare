package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Facility extends DatabaseTenantEntity {

    @ManyToOne
    private Client client;

    @ManyToMany(targetEntity = Pet.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "FacilityPet", joinColumns = @JoinColumn(name = "Facility_ID"), inverseJoinColumns = @JoinColumn(name = "Pet_ID"))
    @OrderColumn
    private Pet[] pets;

    @OneToMany(mappedBy = "facility")
    @OrderColumn
    private ServiceReservation[] serviceReservations;

    @OneToMany(mappedBy = "facility")
    @OrderColumn
    private ServiceExecution[] serviceExecutions;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    @Enumerated(EnumType.STRING)
    private FacilityStatus facilityStatus;

    @ManyToOne
    private Invoice invoice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;

}
