package ch.avendia.petcare.framework.security.session.datastore.memcache;

import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.exception.SessionNotFoundException;
import com.google.common.cache.CacheLoader;

/**
 * Created by Markus on 23.04.2015.
 */
public class NoDatabaseCacheLoader extends CacheLoader<String, Session> {

    @Override
        public Session load(String key) throws SessionNotFoundException {
            throw new SessionNotFoundException();
        }


}
