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
public class Vaccination extends BaseTenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private VaccinationDefinition vaccinationDefinition;

    private String doneBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne
    private Pet pet;
}
