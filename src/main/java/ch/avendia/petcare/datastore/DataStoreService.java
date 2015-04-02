package ch.avendia.petcare.datastore;


import ch.avendia.petcare.datastore.hibernate.DatabaseManagerImpl;
import ch.avendia.petcare.entities.DatabaseEntity;

import javax.persistence.Entity;

/**
 * Created by Markus on 01.04.2015.
 */
public class DataStoreService<T extends DatabaseEntity> {

    public DatabaseManager<T> getDatabaseManager() {
        return new DatabaseManagerImpl<T>();
    }

}
