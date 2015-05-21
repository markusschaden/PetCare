package ch.avendia.petcare.framework.security.session.datastore.redis;

import ch.avendia.petcare.entities.DatabaseEntity;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.security.session.SessionStorage;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * Created by Markus on 20.04.2015.
 */
public class RedisSessionStorage implements SessionStorage {

    private static Jedis jedis;

    public RedisSessionStorage() {
        jedis = new Jedis("localhost");
    }


    public void put(Session session) {
        if(session != null) {
            jedis.set(session.getSessionId(), DatabaseEntity.objToJson(session));
        }
    }

    public Session get(String sessionId) {
        Gson gson = new Gson();

        String obj = jedis.get(sessionId);
        if(obj != null) {
            return gson.fromJson(obj, Session.class);
        }

        return null;
    }

    public void invalidate(Session session) {
        if(session != null) {
            jedis.del(session.getSessionId());
        }
    }

    public Session update(Session session) {
        invalidate(session);
        put(session);
        return session;
    }
}
