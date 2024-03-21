package repository;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface NotificacaoUtilizadorRepository extends JpaRepository<NotificacaoUtilizador, Long>, JpaSpecificationExecutor<NotificacaoUtilizador> {

    public static void criar(NotificacaoUtilizador notifUtil)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(notifUtil);
        em.getTransaction().commit();
    }

    public static void apagar(NotificacaoUtilizador notifUtil)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(notifUtil);
        em.getTransaction().commit();
    }

    public static Utilizador findUtilizadorByNotificacaoId(long idNotificacao)
    {
        NotificacaoUtilizador notifUtil = DbConnection.getEntityManager().find(NotificacaoUtilizador.class, idNotificacao);
        return notifUtil != null ? notifUtil.getIdUtilizador() : null;
    }
}