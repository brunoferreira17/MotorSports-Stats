package repository;

import entity.Competicao;
import entity.CompeticaoFavorito;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CompeticaoFavoritoRepository extends JpaRepository<CompeticaoFavorito, Long>, JpaSpecificationExecutor<CompeticaoFavorito>
{
    // Método para criar uma nova CompeticaoFavorito
    public static void criar(CompeticaoFavorito competicaofavorito)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(competicaofavorito); // Persiste a CompeticaoFavorito no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma CompeticaoFavorito existente
    public static void apagar(CompeticaoFavorito competicaofavorito)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(competicaofavorito); // Remove a CompeticaoFavorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a CompeticaoFavorito
    public static void atualizar(CompeticaoFavorito competicaofavorito)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(competicaofavorito); // Atualiza a CompeticaoFavorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a CompeticaoFavorito pelo seu ID
    public static CompeticaoFavorito findCompeticaoFavorito(int id)
    {
        return DbConnection.getEntityManager().find(CompeticaoFavorito.class, id); // Retorna a CompeticaoFavorito com o ID fornecido
    }

    // Método para listar todas as CompeticaoFavorito
    public static List<CompeticaoFavorito> listar()
    {
        return DbConnection.getEntityManager().createQuery("from CompeticaoFavorito ", CompeticaoFavorito.class).getResultList(); // Retorna uma lista de todas as CompeticaoFavoritos no banco de dados
    }
}