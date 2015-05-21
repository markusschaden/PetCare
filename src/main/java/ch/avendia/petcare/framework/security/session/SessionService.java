package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;

/**
 * Created by Markus on 02.04.2015.
 */
public interface SessionService {

    Session getSession(String sessionId);
    Session addSession(Account account);
    void removeSession(Session session);
    Session updateSession(Session session);

}
