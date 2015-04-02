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
public class Payment extends DatabaseEntity {

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private long amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne
    private Invoice invoice;
}
