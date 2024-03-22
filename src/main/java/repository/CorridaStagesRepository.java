package repository;

import entity.Corrida;
import entity.CorridaStage;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CorridaStagesRepository extends JpaRepository<CorridaStage, Long>, JpaSpecificationExecutor<CorridaStage>
{
    // Método para criar uma nova CorridaStage
    public static void criar(CorridaStage corridastage)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(corridastage); // Persiste a Corrida no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma CorridaStage existente
    public static void apagar(CorridaStage corridastage)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(corridastage); // Remove a CorridaStage do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a Corrida
    public static void atualizar(CorridaStage corridastage)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(corridastage); // Atualiza a Corrida do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a Corrida pelo seu ID
    public static CorridaStage findCorridaStage(int id)
    {
        return DbConnection.getEntityManager().find(CorridaStage.class, id); // Retorna a CorridaStage com o ID fornecido
    }

    // Método para listar todas as CorridaStage
    public static List<CorridaStage> listar()
    {
        return DbConnection.getEntityManager().createQuery("from CorridaStage", CorridaStage.class).getResultList(); // Retorna uma lista de todas as CorridasStage no banco de dados
    }

}