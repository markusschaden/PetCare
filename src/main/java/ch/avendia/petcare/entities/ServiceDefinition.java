package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class ServiceDefinition extends DatabaseTenantEntity {

    private boolean isDisabled;
    private String title;
    private String description;
    private long price;
}
