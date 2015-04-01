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
public class Reservation extends BaseTenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany(targetEntity = Pet.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ReservationPet", joinColumns = @JoinColumn(name = "Reservation_ID"), inverseJoinColumns = @JoinColumn(name = "Pet_ID"))
    private Pet[] pets;

    @OneToMany(mappedBy = "reservation")
    private ServiceReservation[] serviceReservations;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
}
