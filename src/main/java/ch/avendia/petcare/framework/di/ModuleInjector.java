package ch.avendia.petcare.framework.di;

import ch.avendia.petcare.externalservices.sms.SMSGateway;
import ch.avendia.petcare.externalservices.sms.swisscom.SwisscomSMSGateway;
import ch.avendia.petcare.framework.logging.Log4JTypeListener;
import ch.avendia.petcare.framework.security.session.SessionService;
import ch.avendia.petcare.framework.security.session.SessionServiceImpl;
import ch.avendia.petcare.framework.security.session.SessionStorage;
import ch.avendia.petcare.framework.security.session.datastore.memcache.SessionStorageImpl;
import ch.avendia.petcare.services.implementations.UserService;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * Created by Markus on 23.04.2015.
 */
public class ModuleInjector extends AbstractModule {

    @Override
    protected void configure() {

        /* LOG4J2 */
        bindListener(Matchers.any(), new Log4JTypeListener());


        /* Services */
        bind(UserService.class).in(Singleton.class);


        /* External Services */
        bind(SMSGateway.class).to(SwisscomSMSGateway.class);


        /* Business Logic */



        /* DAO */


        /* Session */
        bind(SessionService.class).to(SessionServiceImpl.class);
        bind(SessionStorage.class).to(SessionStorageImpl.class);



        /* bind jackson converters for JAXB/JSON serialization */
        bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
        bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);





    }
}
