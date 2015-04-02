package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
public abstract class ServiceExecution extends DatabaseTenantEntity {

    @ManyToOne
    private ServiceDefinition serviceDefinition;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Facility facility;
}
