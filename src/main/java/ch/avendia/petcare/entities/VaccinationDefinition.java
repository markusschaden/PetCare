package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class VaccinationDefinition extends DatabaseTenantEntity {

    private String name;

    private String description;
}
