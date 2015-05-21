package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Data
@Entity
public class Food extends DatabaseEntity {

    private String description;

    @ManyToOne
    private Pet pet;
}
