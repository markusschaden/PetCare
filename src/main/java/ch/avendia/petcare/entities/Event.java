package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Event extends DatabaseTenantEntity {

    public String title;
    public String description;

}
