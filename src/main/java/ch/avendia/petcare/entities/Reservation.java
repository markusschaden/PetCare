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
public class Reservation extends DatabaseTenantEntity {

    @ManyToOne
    private Client client;

    @ManyToMany(targetEntity = Pet.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ReservationPet", joinColumns = @JoinColumn(name = "Reservation_ID"), inverseJoinColumns = @JoinColumn(name = "Pet_ID"))
    @OrderColumn
    private Pet[] pets;

    @OneToMany(mappedBy = "reservation")
    @OrderColumn
    private ServiceReservation[] serviceReservations;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
}
