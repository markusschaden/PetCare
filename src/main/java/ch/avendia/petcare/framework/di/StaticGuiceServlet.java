package ch.avendia.petcare.framework.di;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Markus on 20.04.2015.
 */
public class StaticGuiceServlet extends ServletModule {
    @Override
    public void configureServlets() {
        /* blah blah blah another initialization */

        /* You acquire these somehow from your configuration*/
        String uploadRoot = "./";;

        Class<HttpServlet> defaultServletClass = getJbossDefaultServletClass();
        bind(defaultServletClass).in(Singleton.class);
        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("dirAllowed", "false"); //that's up to you
        initParams.put("pathInfoOnly", "true"); //exclude the servlet's context path,
        //so that the local dir paths are shorter
        initParams.put("resourceBase", uploadRoot);
        serve(uploadRoot + "*").with(defaultServletClass, initParams);
    }

    private Class<HttpServlet> getJbossDefaultServletClass() {
        try {
            Class<?> clazz = Class.forName("javax.servlet.http.HttpServlet");
            if (HttpServlet.class.isAssignableFrom(clazz)) {
                return (Class<HttpServlet>) clazz;
            }
            throw new IllegalStateException("Class " + clazz + " cannot be used as a HttpServlet");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Could not acquire Class of Jetty's DefaultServlet");
        }
    }
}