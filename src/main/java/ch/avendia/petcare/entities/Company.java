package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private TransferData transferData;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "companies",
            targetEntity = Animal.class
    )
    private Animal[] animals;

    @OneToOne
    private CompanySettings companySettings;
}
