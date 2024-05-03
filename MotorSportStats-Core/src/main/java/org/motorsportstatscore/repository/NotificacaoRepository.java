package org.motorsportstatscore.repository;

import jakarta.persistence.EntityManager;

import org.motorsportstatscore.entity.Notificacao;
import org.motorsportstatscore.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>, JpaSpecificationExecutor<Notificacao> {

    public static void criar(Notificacao notif) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(notif);
        em.getTransaction().commit();
    }

    public static void apagar(Notificacao notif) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(notif);
        em.getTransaction().commit();
    }

    public static Notificacao findNotificacao(long id) {
        return DbConnection.getEntityManager().find(Notificacao.class, id);
    }

    public static Set<Notificacao> findNotificacaoUtilizador(int id) {
        Utilizador utilizador = DbConnection.getEntityManager().find(Utilizador.class, id);
        return utilizador.getNotificacaos();
    }

    public static List<Notificacao> listar() {
        return DbConnection.getEntityManager().createQuery("from Notificacao", Notificacao.class).getResultList();
    }

    public static List<Notificacao> listarWithType(String tituloNotificacao) {
        return DbConnection.getEntityManager().createQuery("from Notificacao where tituloNotificacao = ?1", Notificacao.class).setParameter(1, tituloNotificacao).getResultList();
    }
}