package repository;

import entity.Equipa;
import entity.Utilizador;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EquipaRepository extends JpaRepository<Equipa, Long>, JpaSpecificationExecutor<Equipa>
{
    // Método para criar uma nova Equipa
    public static void criar(Equipa equipa)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(equipa); // Persiste a Equipa no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma Equipa existente
    public static void apagar(Equipa equipa)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(equipa); // Remove a Equipa do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a Equipa
    public static void atualizar(Equipa equipa)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(equipa); // Atualiza a Equipa do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a equipa pelo seu ID
    public static Equipa findEquipa(int id)
    {
        return DbConnection.getEntityManager().find(Equipa.class, id); // Retorna a Equipa com o ID fornecido
    }

    // Método para listar todas as Equipas
    public static List<Equipa> listar()
    {
        return DbConnection.getEntityManager().createQuery("from Equipa ", Equipa.class).getResultList(); // Retorna uma lista de todas as Equipas no banco de dados
    }
}