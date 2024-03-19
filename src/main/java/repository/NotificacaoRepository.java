package repository;

import entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Set;

public class NotificacaoRepository {

    public static void criar(Notificacao notif){
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(notif);
        em.getTransaction().commit();
    }

    public static void apagar(Notificacao notif){
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(notif);
        em.getTransaction().commit();
    }

    public static Notificacao findNotificacao(long id){
        return DbConnection.getEntityManager().find(Notificacao.class, id);
    }

    public static Set<Notificacao> finNotificacaoUtilizador(long id){
        Utilizador util = DbConnection.getEntityManager().find(Utilizador.class, id);
        return util.getNotificacaos();
    }

    public static List<Notificacao> listar(){
        return DbConnection.getEntityManager().createQuery("from Notificacao", Notificacao.class).getResultList();
    }

    public static List<Notificacao> listarWithType(String tipoNotificacao){
        return DbConnection.getEntityManager().createQuery("from Notificacao where tipoNotificacao = ?1", Notificacao.class)
                .setParameter(1, tipoNotificacao).getResultList();
    }
}
