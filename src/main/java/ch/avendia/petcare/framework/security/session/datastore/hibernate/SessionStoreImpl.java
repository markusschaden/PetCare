package ch.avendia.petcare.framework.security.session.datastore.hibernate;

import ch.avendia.petcare.datastore.DataStoreService;
import ch.avendia.petcare.datastore.DatabaseManager;
import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.security.session.SessionFactory;
import ch.avendia.petcare.framework.security.session.SessionStore;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Markus on 02.04.2015.
 */
public class SessionStoreImpl implements SessionStore {

    private DatabaseManager<Session> sessionDatabaseManager;

    public SessionStoreImpl() {
        DataStoreService<Session> sessionDataStoreService = new DataStoreService<Session>();
        sessionDatabaseManager = sessionDataStoreService.getDatabaseManager();
    }

    public Session getSession(String sessionId) {
        return sessionDatabaseManager.get(Session.class, sessionId);
    }

    public Session addSession(Account account) {

        SessionFactory sessionFactory = new SessionFactory();
        Session session = sessionFactory.createSession(account);

        return sessionDatabaseManager.add(session);
    }

    public Session updateSession(Session session) {
        return null;
    }

    public void removeSession(Session session) {

    }
}
