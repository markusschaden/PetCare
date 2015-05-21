package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;
import com.google.inject.Inject;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Markus on 02.04.2015.
 */
public class SessionFactory {

    @Inject
    private SessionIdentifierGenerator sig;

    public Session createSession(Account account) {

        String sessionId = sig.createWord(64);
        LocalDateTime current = LocalDateTime.now();
        current.plusDays(7);
        Instant instant = current.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        Session session = new Session();
        session.setAccount(account);
        session.setSessionId(sessionId);
        session.setValidTill(date);


        return session;
    }



}
