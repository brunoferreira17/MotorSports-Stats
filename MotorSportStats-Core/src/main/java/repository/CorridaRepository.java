package repository;

import entity.Competicao;
import entity.Corrida;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CorridaRepository extends JpaRepository<Corrida, Long>, JpaSpecificationExecutor<Corrida>
{
    // Método para criar uma nova Corrida
    public static void criar(Corrida corrida)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(corrida); // Persiste a Corrida no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma Corrida existente
    public static void apagar(Corrida corrida)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(corrida); // Remove a Corrida do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a Corrida
    public static void atualizar(Corrida corrida)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(corrida); // Atualiza a Corrida do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a Corrida pelo seu ID
    public static Corrida findCorrida(int id)
    {
        return DbConnection.getEntityManager().find(Corrida.class, id); // Retorna a Corrida com o ID fornecido
    }

    // Método para listar todas as Corridas
    public static List<Corrida> listar()
    {
        return DbConnection.getEntityManager().createQuery("from Corrida", Corrida.class).getResultList(); // Retorna uma lista de todas as Corridas no banco de dados
    }
}