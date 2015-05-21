package ch.avendia.petcare.services.implementations;

import ch.avendia.petcare.entities.DatabaseEntity;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.entities.transfer.BasicRequestDTO;
import ch.avendia.petcare.framework.exception.InvalidTokenException;
import ch.avendia.petcare.framework.exception.NoSessionException;
import ch.avendia.petcare.framework.security.session.SessionIdentifierGenerator;
import ch.avendia.petcare.framework.security.session.SessionService;
import com.google.inject.Inject;

/**
 * Created by Markus on 01.04.2015.
 */
public abstract class BasicService {

    @Inject
    protected SessionService sessionService;

    @Inject
    private SessionIdentifierGenerator sig;

    protected Session session;

    public void check(BasicRequestDTO<? extends DatabaseEntity> dto) {
        if (dto != null) {
            session = sessionService.getSession(dto.getSessionId());
            if (session == null) {
                session = sessionService.addSession(null);
            }
            checkToken(dto);
        }
    }

    public void checkToken(BasicRequestDTO<? extends DatabaseEntity> dto) {
        if (dto == null || !isValidToken(dto.getToken())) {
            throw new InvalidTokenException();
        }
    }

    private boolean isValidToken(String token) {
        if(token != null && session != null && token.equals(session.getToken())) {
            return true;
        }

        return false;
    }

}
