package ch.avendia.petcare.services.endpoints;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Markus on 01.04.2015.
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
    @SuppressWarnings("unchecked")
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(UserService.class));
    }
}
