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
public class Session extends DatabaseEntity {

    @ManyToOne
    private Account account;

    private String sessionId;

    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date validTill;
}
