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
public class PetPicture extends DatabaseEntity {

    private String description;
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;

    @ManyToOne
    private Pet pet;
}
