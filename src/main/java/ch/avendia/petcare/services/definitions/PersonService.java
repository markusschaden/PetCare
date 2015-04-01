package ch.avendia.petcare.services.definitions;

import ch.avendia.petcare.entities.Client;

/**
 * Created by Markus on 01.04.2015.
 */
public interface PersonService {

    public Client[] getUsers();
    public void addUser(Client user);
    public void removeUser(Client user);
    public void editUser(Client user);

}
