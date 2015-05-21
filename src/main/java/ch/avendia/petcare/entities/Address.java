package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Embeddable
@Access(AccessType.PROPERTY)
@Data
public class Address {

    @ManyToOne
    private Country country;
    private String village;
    private String zipCode;
    private String street;

}
