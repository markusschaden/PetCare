package ch.avendia.petcare.entities;

/**
 * Created by Markus on 01.04.2015.
 */
public class Pet {

    private Animal animal;
    private String species;
    private String name;
    private Client owner;
    private PetPicture[] pictures;

    private Vaccination[] vaccinations;
    private Allergie[] allergies;

}
