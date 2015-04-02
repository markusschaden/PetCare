package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.framework.security.session.datastore.memcache.SessionStoreImpl;

/**
 * Created by Markus on 02.04.2015.
 */
public class SessionService {

    private SessionStore sessionStore;

    private static SessionService instance;

    private SessionService() {

        sessionStore = new SessionStoreImpl();
    }

    public SessionStore getSessionStore() {
        return sessionStore;
    }

    public static SessionService getInstance() {
        if(instance == null) {
            synchronized (SessionService.class) {
                if(instance == null) {
                    instance = new SessionService();
                }
            }
        }
        return instance;
    }

}
