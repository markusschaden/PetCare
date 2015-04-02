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
public class CompanySettings extends DatabaseEntity {

    @Enumerated(EnumType.STRING)
    private ColorSchema colorSchema;
    @Temporal(TemporalType.TIMESTAMP)
    private Date activeTill;
    private boolean isTrial;
    private long tax;
}
