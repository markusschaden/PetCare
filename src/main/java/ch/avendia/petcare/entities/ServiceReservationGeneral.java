package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class ServiceReservationGeneral extends ServiceReservation {

    @ManyToOne
    private ServiceDefinition serviceDefinition;

    private int amount;
}
