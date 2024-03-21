package repository;


import entity.Notificacao;
import entity.TipoUtilizador;
import entity.Utilizador;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>, JpaSpecificationExecutor<Utilizador>
{
    // Método para criar um novo utilizador
    public static void criar(Utilizador utilizador)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(utilizador); // Persiste o utilizador no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar um utilizador existente
    public static void apagar(Utilizador utilizador)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(utilizador); // Remove o utilizador do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar um utilizador pelo seu ID
    public static Utilizador findUtilizador(int id)
    {
        return DbConnection.getEntityManager().find(Utilizador.class, id); // Retorna o utilizador com o ID fornecido
    }

    // Método para listar todos os utilizadores
    public static List<Utilizador> listar()
    {
        return DbConnection.getEntityManager().createQuery("from Utilizador", Utilizador.class).getResultList(); // Retorna uma lista de todos os utilizadores no banco de dados
    }

    /*public static List<Utilizador> listarWithType(TipoUtilizador TipoUtilizador)
    {
        return DbConnection.getEntityManager().createQuery("from Utilizador ", Utilizador.class).setParameter(1,TypeUtilizador).getResultList();
    }*/




}