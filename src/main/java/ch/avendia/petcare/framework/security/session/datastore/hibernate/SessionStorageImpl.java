package ch.avendia.petcare.framework.security.session.datastore.hibernate;

import ch.avendia.petcare.datastore.DataStoreService;
import ch.avendia.petcare.datastore.DatabaseManager;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.security.session.SessionFactory;
import ch.avendia.petcare.framework.security.session.SessionService;
import ch.avendia.petcare.framework.security.session.SessionStorage;

/**
 * Created by Markus on 02.04.2015.
 */
public class SessionStorageImpl implements SessionStorage {

    private DatabaseManager<Session> sessionDatabaseManager;

    public SessionStorageImpl() {
        DataStoreService<Session> sessionDataStoreService = new DataStoreService<Session>();
        sessionDatabaseManager = sessionDataStoreService.getDatabaseManager();
    }

    public Session get(String sessionId) {
        return sessionDatabaseManager.get(Session.class, sessionId);
    }

    public void put(Session session) {
        sessionDatabaseManager.add(session);
    }

    public void invalidate(Session session) {
        sessionDatabaseManager.delete(session);
    }

    public Session update(Session session) {
        return sessionDatabaseManager.update(session);
    }
}
