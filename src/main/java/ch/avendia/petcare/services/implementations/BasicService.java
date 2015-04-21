package ch.avendia.petcare.services.implementations;

/**
 * Created by Markus on 01.04.2015.
 */
public abstract class BasicService {


    public boolean isValidToken(String token) {

        return false;
    }

    public String generateToken() {

        return null;
    }

    public boolean isAuthorized() {

        return false;
    }


}
