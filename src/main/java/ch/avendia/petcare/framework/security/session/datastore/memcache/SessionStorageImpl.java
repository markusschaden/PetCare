package ch.avendia.petcare.framework.security.session.datastore.memcache;

import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.security.session.SessionStorage;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Markus on 23.04.2015.
 */
public class SessionStorageImpl implements SessionStorage {

    private LoadingCache<String, Session> sessionStorage;

    public SessionStorageImpl() {
        sessionStorage = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .weakKeys()
                .maximumSize(100000)
                .expireAfterAccess(60, TimeUnit.MINUTES)
                .build(new NoDatabaseCacheLoader());
    }


    public Session get(String sessionId) {
        try {
            return sessionStorage.get(sessionId);
        } catch (ExecutionException e) {
            return null;
        }
    }

    public void put(Session session) {
        if(session != null) {
            sessionStorage.put(session.getSessionId(), session);
        }
    }

    public void invalidate(Session session) {
        if(session != null) {
            sessionStorage.invalidate(session.getSessionId());
        }
    }

    public Session update(Session session) {
        invalidate(session);
        put(session);
        return session;
    }
}
