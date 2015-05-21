package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.logging.InjectLogger;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.logging.log4j.Logger;

/**
 * Created by Markus on 02.04.2015.
 */
@Singleton
public class SessionServiceImpl implements SessionService {

    @InjectLogger
    private Logger logger;

    @Inject
    private SessionStorage sessionStorage;

    @Inject
    private SessionFactory sessionFactory;

    public Session getSession(String sessionId) {

        return sessionStorage.get(sessionId);
    }

    public Session addSession(Account account) {

        logger.debug("Create session for account: " + account);

        Session newSession = sessionFactory.createSession(account);

        sessionStorage.put(newSession);

        logger.debug("Session created: " + newSession);

        return newSession;
    }

    public void removeSession(Session session) {

        sessionStorage.invalidate(session);
    }

    public Session updateSession(Session session) {

        return sessionStorage.update(session);
    }
}
