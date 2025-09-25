package uz.pdp.g56_online_market.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import uz.pdp.g56_online_market.config.JpaConfig;
import uz.pdp.g56_online_market.entities.Outcome;

import java.util.List;

public class OutcomeDAO {

    // Outcome saqlash
    public void save(Outcome outcome) {
        EntityManager em = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(outcome);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Outcome yangilash
    public void update(Outcome outcome) {
        EntityManager em = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(outcome);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Outcome o‘chirish
    public void delete(Long id) {
        EntityManager em = JpaConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Outcome outcome = em.find(Outcome.class, id);
            if (outcome != null) {
                em.remove(outcome);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Outcome topish (id bo‘yicha)
    public Outcome findById(Long id) {
        EntityManager em = JpaConfig.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Outcome.class, id);
        } finally {
            em.close();
        }
    }

    // Outcome’larning barchasini olish
//    public List<Outcome> findAll() {
//        EntityManager em = JpaConfig.getEntityManagerFactory().createEntityManager();
//        try {
//            return em.createQuery("SELECT o FROM Outcome o", Outcome.class) // Outcome klass nomi!
//                    .getResultList();
//        } finally {
//            em.close();
//        }
//    }

    public List<Outcome> findAll() {
            EntityManager em = JpaConfig.getEntityManagerFactory().createEntityManager();
            try {
                return em.createQuery("select o from Outcome o", Outcome.class)
                        .getResultList();
            } finally {
                em.close();
            }
        }


}

