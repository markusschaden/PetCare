package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Markus on 01.04.2015.
 */
@MappedSuperclass
@Data
public abstract class DatabaseTenantEntity extends DatabaseEntity {

    @ManyToOne
    private Company tenant;
}
