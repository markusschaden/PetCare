package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;

/**
 * Created by Markus on 02.04.2015.
 */
public interface SessionStore {

    public Session getSession(String sessionId);
    public Session addSession(Account account);
    public Session updateSession(Session session);
    public void removeSession(Session session);

}
