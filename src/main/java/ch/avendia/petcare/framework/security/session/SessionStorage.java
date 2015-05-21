package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.entities.Session;

/**
 * Created by Markus on 23.04.2015.
 */
public interface SessionStorage {

    Session get(String sessionId);
    void put(Session session);
    void invalidate(Session session);
    Session update(Session session);
}
