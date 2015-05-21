package ch.avendia.petcare.framework.security.session;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.di.ModuleInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Markus on 20.04.2015.
 */
public class SessionIdentifierGeneratorTest {

    Injector injector;

    @Before
    public void setup() {
        injector = Guice.createInjector(new ModuleInjector());

    }

    @Test
    public void testSessionStore() {

        SessionService sessionService = injector.getInstance(SessionService.class);

        Account a = new Account();
        a.setUsername("testUser");
        Session s = sessionService.addSession(a);

        Session loadedSession = sessionService.getSession(s.getSessionId());

        assertEquals(s, loadedSession);
    }


    public static void main(String[] args) throws InterruptedException {

        Injector injector = Guice.createInjector(new ModuleInjector());

        SessionIdentifierGenerator sig = new SessionIdentifierGenerator();

        for(int i=0;i<10;i++)
        System.out.println(sig.createWord(64));


        SessionService sessionStore = injector.getInstance(SessionService.class);

        Account a = new Account();
        a.setUsername("testUser");

        Session s = sessionStore.addSession(a);


        Session loadedSession = sessionStore.getSession(s.getSessionId());
        System.out.println(loadedSession);

        Session invalidSession = sessionStore.getSession("test");
        System.out.println(invalidSession);

        Thread.sleep(10000);

        Session loadedSession2 = sessionStore.getSession(s.getSessionId());
        System.out.println(loadedSession2);


    }

}
