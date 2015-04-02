package ch.avendia.petcare.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Markus on 01.04.2015.
 */
@Entity
@Data
public class Animal extends DatabaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String image;

    @OneToMany(mappedBy = "animal")
    private Pet[] pets;

    @ManyToMany(targetEntity = Company.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "AnimalCompany", joinColumns = @JoinColumn(name = "Animal_ID"), inverseJoinColumns = @JoinColumn(name = "Company_ID"))
    private Company[] companies;
}
