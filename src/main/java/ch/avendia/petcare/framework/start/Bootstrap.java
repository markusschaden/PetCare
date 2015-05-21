package ch.avendia.petcare.framework.start;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.reflections.Reflections;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.util.Set;

/**
 * Created by Markus on 21.05.2015.
 */
public class Bootstrap implements ServletContextListener {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Configuration configuration;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        configuration = new Configuration();
        configuration.configure();

        Reflections reflections = new Reflections("ch.avendia.petcare.entities");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);
        for(Class<?> clazz : classes) {
            configuration.addAnnotatedClass(clazz);
        }

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static void buildSchema() {
        SchemaExport schemaExport = new SchemaExport(serviceRegistry, configuration);
        schemaExport.setOutputFile("C:\\temp\\ddl.sql");
        schemaExport.setDelimiter(";");
        schemaExport.setFormat(true);

        schemaExport.execute(true, false, false, true);
    }

    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();

    }



    public void contextInitialized(ServletContextEvent event) {
        getSessionFactory();
        buildSchema();
    }

    public void contextDestroyed(ServletContextEvent event) {
    //    HibernateUtil.getSessionFactory().close(); // Free all resources
    }


}
