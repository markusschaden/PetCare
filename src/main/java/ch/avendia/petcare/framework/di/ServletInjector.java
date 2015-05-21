package ch.avendia.petcare.framework.di;

import ch.avendia.petcare.framework.security.session.SessionService;
import ch.avendia.petcare.framework.security.session.SessionServiceImpl;
import ch.avendia.petcare.framework.security.session.SessionStorage;
import ch.avendia.petcare.framework.security.session.datastore.memcache.SessionStorageImpl;
import ch.avendia.petcare.services.implementations.UserService;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Markus on 23.04.2015.
 */
public class ServletInjector extends ServletModule {

    @Override
    protected void configureServlets() {

        /* Services */
        //bind(UserService.class).in(Singleton.class);


        /* Business Logic */



        /* DAO */


        /* Session */
        //bind(SessionService.class).to(SessionServiceImpl.class);
        //bind(SessionStorage.class).to(SessionStorageImpl.class);



        /* bind jackson converters for JAXB/JSON serialization */
        //bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
        //bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);



        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("com.sun.jersey.config.feature.Trace", "true");
        initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        serve("/rest/*").with(GuiceContainer.class, initParams);
    }

}
