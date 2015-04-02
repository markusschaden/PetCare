package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Discount extends DatabaseTenantEntity {

    private String name;
    private boolean inPercent;
    private long amount;

    private boolean disabled;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "discounts",
            targetEntity = Invoice.class
    )
    private Invoice[] invoices;
}
