package repository;

import entity.Corrida;
import entity.CorridaVolta;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CorridaVoltasRepository extends JpaRepository<CorridaVolta, Long>, JpaSpecificationExecutor<CorridaVolta>
{
    // Método para criar uma nova CorridaVolta
    public static void criar(CorridaVolta corridavolta)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(corridavolta); // Persiste a Corrida no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma CorridaVolta existente
    public static void apagar(CorridaVolta corridavolta)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(corridavolta); // Remove a CorridaVolta do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a CorridaVolta
    public static void atualizar(CorridaVolta corridavolta)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(corridavolta); // Atualiza a Corrida do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a Corrida pelo seu ID
    public static CorridaVolta findCorridaVolta(int id)
    {
        return DbConnection.getEntityManager().find(CorridaVolta.class, id); // Retorna a CorridaVolta com o ID fornecido
    }

    // Método para listar todas as Corridas
    public static List<CorridaVolta> listar()
    {
        return DbConnection.getEntityManager().createQuery("from CorridaVolta", CorridaVolta.class).getResultList(); // Retorna uma lista de todas as CorridasVolta no banco de dados
    }
}