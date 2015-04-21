package ch.avendia.petcare.framework.di;

import ch.avendia.petcare.services.implementations.UserService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Markus on 20.04.2015.
 */
    public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {

            @Override
            protected void configureServlets() {

                bind(UserService.class).in(Singleton.class);

                /* bind jackson converters for JAXB/JSON serialization */
                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);
                Map<String, String> initParams = new HashMap<String, String>();
                initParams.put("com.sun.jersey.config.feature.Trace",
                        "true");
                initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

                serve( "/rest/*" ).with( GuiceContainer.class, initParams );
            }

        });
    }


    private Class<HttpServlet> getDefaultServletClass() {
        try {
            Class<?> clazz = Class.forName("org.apache.catalina.servlets.DefaultServlet");
            if (HttpServlet.class.isAssignableFrom(clazz)) {
                return (Class<HttpServlet>) clazz;
            }
            throw new IllegalStateException("Class " + clazz + " cannot be used as a HttpServlet");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Could not acquire Class of Jetty's DefaultServlet");
        }
    }

}
