package ch.avendia.petcare.entities;

/**
 * Created by Markus on 01.04.2015.
 */
public class Employee extends BaseTenant{

    private Position position;
    private String name;
    private String firstname;
    private String phoneNumber;
    private String email;
    private String birthday;
    private Right[] rights;
    private Account account;
}
