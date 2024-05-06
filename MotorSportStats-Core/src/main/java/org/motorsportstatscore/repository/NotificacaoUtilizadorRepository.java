package org.motorsportstatscore.repository;

import jakarta.persistence.EntityManager;

import org.motorsportstatscore.entity.NotificacaoUtilizador;
import org.motorsportstatscore.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoUtilizadorRepository extends JpaRepository<NotificacaoUtilizador, Long>, JpaSpecificationExecutor<NotificacaoUtilizador> {

    public static void criar(NotificacaoUtilizador notifUtil) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(notifUtil);
        em.getTransaction().commit();
    }

    public static void apagar(NotificacaoUtilizador notifUtil) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(notifUtil);
        em.getTransaction().commit();
    }

    public static Utilizador findUtilizadorByNotificacaoId(long idNotificacao) {
        NotificacaoUtilizador notifUtil = DbConnection.getEntityManager().find(NotificacaoUtilizador.class, idNotificacao);
        return notifUtil != null ? notifUtil.getIdUtilizador() : null;
    }

}