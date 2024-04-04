package repository;

import entity.Equipa;
import entity.EquipaCompeticao;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EquipaCompeticaoRepository extends JpaRepository<EquipaCompeticao, Long>, JpaSpecificationExecutor<EquipaCompeticao>
{
    // Método para criar uma nova EquipaCompeticao
    public static void criar(EquipaCompeticao equipacompeticao)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(equipacompeticao); // Persiste a EquipaCompeticao no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma EquipaCompeticao existente
    public static void apagar(EquipaCompeticao equipacompeticao)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(equipacompeticao); // Remove a Equipa do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a EquipaCompeticao
    public static void atualizar(EquipaCompeticao equipacompeticao)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(equipacompeticao); // Atualiza a EquipaCompeticao do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a equipa pelo seu ID
    public static EquipaCompeticao findEquipaCompeticao(int id)
    {
        return DbConnection.getEntityManager().find(EquipaCompeticao.class, id); // Retorna a EquipaCompeticao com o ID fornecido
    }

    // Método para listar todas as Equipas
    public static List<EquipaCompeticao> listar()
    {
        return DbConnection.getEntityManager().createQuery("from EquipaCompeticao ", EquipaCompeticao.class).getResultList(); // Retorna uma lista de todas as EquipaCompeticao no banco de dados
    }

}