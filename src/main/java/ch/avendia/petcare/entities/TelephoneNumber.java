package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * Created by Markus on 21.05.2015.
 */
@Embeddable
@Access(AccessType.PROPERTY)
@Data
public class TelephoneNumber {

    private String countryCode;
    private String phoneNumber;
}
