package ch.avendia.petcare.business;

import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.security.session.SessionService;
import ch.avendia.petcare.framework.security.session.SessionStore;

/**
 * Created by Markus on 02.04.2015.
 */
public abstract class BaseSessionBusiness extends BaseBusiness {

    private SessionStore sessionStore;
    private String sessionId;
    public BaseSessionBusiness(String sessionId) {
        this.sessionId = sessionId;
        sessionStore = SessionService.getInstance().getSessionStore();
    }

    protected Session getSession() {

        return null;
    }



}
