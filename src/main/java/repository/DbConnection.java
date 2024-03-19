package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DbConnection {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    //private static EntityTransaction transaction = em.getTransaction();

    public static EntityManager getEntityManager(){
        return em;
    }
}
