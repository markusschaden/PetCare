package ch.avendia.petcare.datastore;

import ch.avendia.petcare.entities.Account;
import ch.avendia.petcare.entities.DatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Markus on 01.04.2015.
 */
public interface DatabaseManager<T extends DatabaseEntity> {

    public Set<T> getAll(T clazz);
    public T add(T at);
    public T update(T t);
    public void delete(T t);
    public T get(Class<T> clazz, String id);
    public Set<T> find(String sql, Map<String, String> values);

}
