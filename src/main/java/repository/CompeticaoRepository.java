package repository;

import entity.Competicao;
import entity.Equipa;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CompeticaoRepository extends JpaRepository<Competicao, Long>, JpaSpecificationExecutor<Competicao>
{
    // Método para criar uma nova Competiçao
    public static void criar(Competicao competicao)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(competicao); // Persiste a Competicao no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma Competicao existente
    public static void apagar(Competicao competicao)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(competicao); // Remove a Competicao do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a Competicao
    public static void atualizar(Competicao competicao)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(competicao); // Atualiza a Competicao do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a Competicao pelo seu ID
    public static Competicao findCompeticao(int id)
    {
        return DbConnection.getEntityManager().find(Competicao.class, id); // Retorna a Competicao com o ID fornecido
    }

    // Método para listar todas as Competiçoes
    public static List<Competicao> listar()
    {
        return DbConnection.getEntityManager().createQuery("from Competicao ", Competicao.class).getResultList(); // Retorna uma lista de todas as Competicoes no banco de dados
    }
}