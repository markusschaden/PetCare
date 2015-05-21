package ch.avendia.petcare.datastore.hibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Markus on 01.04.2015.
 */
public class HibernateService {

    private static HibernateService instance;

    private EntityManager em;

    private HibernateService() {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
        emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public static HibernateService getInstance() {
        if(instance == null) {
            synchronized (HibernateService.class) {
                if(instance == null) {
                    instance = new HibernateService();
                }
            }
        }
        return instance;
    }

}
