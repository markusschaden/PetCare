package ch.avendia.petcare.datastore.hibernate;


import ch.avendia.petcare.datastore.DatabaseManager;
import ch.avendia.petcare.entities.DatabaseEntity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Markus on 01.04.2015.
 */
public class DatabaseManagerImpl<T extends DatabaseEntity> implements DatabaseManager<T> {

    private EntityManager em;

    public DatabaseManagerImpl() {

        HibernateService.getInstance().getEntityManager();

    }

    public Set<T> getAll(T clazz) {
        Query query = em.createQuery("from " + clazz.getClass().getSimpleName() + " e where e.CompanyId = :companyId");
        query.setParameter("companyId", "1");
        return new HashSet<T>(query.getResultList());

    }

    public T add(T entity) {
        em.persist(entity);
        return entity;
    }

    public T update(T entity) {
        return null;
    }

    public void delete(T entity) {
        em.remove(entity);
    }

    public T get(Class<T> clazz, String id) {
        return (T)em.find(clazz, id);
    }

    public Set<T> find(String sql, Map<String, String> values) {

        Query query = em.createQuery(sql);
        for(Map.Entry<String, String> entry: values.entrySet()){
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return new HashSet<T>(query.getResultList());
    }
}
