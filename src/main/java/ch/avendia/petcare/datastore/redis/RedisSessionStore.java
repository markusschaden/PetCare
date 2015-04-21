package ch.avendia.petcare.datastore.redis;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.DatabaseEntity;
import ch.avendia.petcare.entities.Session;
import ch.avendia.petcare.framework.security.session.SessionStore;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * Created by Markus on 20.04.2015.
 */
public class RedisSessionStore implements SessionStore {

    private static Jedis jedis;

    public RedisSessionStore() {
        jedis = new Jedis("localhost");
    }


    public void storeSession(String sessionId, Account obj) {
        jedis.set(sessionId, DatabaseEntity.objToJson(obj));
    }

    public Session getSession(String sessionId) {
        Gson gson = new Gson();

        String obj = jedis.get(sessionId);
        if(obj != null) {
            return gson.fromJson(obj, Session.class);
        }

        return null;
    }

    public Session addSession(Session session) {
        return null;
    }

    public void removeSession(Session session) {

    }
}
