package ch.avendia.petcare.framework.logging;

import com.google.inject.MembersInjector;
import com.google.inject.spi.InjectionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

/**
 * Created by Markus on 23.04.2015.
 */
public class Log4JMembersInjector<T> implements MembersInjector<T> {

    private final Field field;
    private final Logger logger;

    Log4JMembersInjector(Field field) {
        this.field = field;
        this.logger = LogManager.getLogger(field.getDeclaringClass().getName());
        field.setAccessible(true);
    }

    public void injectMembers(T t) {
        try {
            field.set(t, logger);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
