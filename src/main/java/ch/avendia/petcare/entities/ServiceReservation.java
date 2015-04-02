package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Data
public abstract class ServiceReservation extends DatabaseTenantEntity {

    @ManyToOne
    private ServiceDefinition serviceDefinition;

    private int amount;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    private Reservation reservation;
}
