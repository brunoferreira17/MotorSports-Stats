package repository;

import entity.Equipa;
import entity.Piloto;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PilotoRepository extends JpaRepository<Piloto, Long>, JpaSpecificationExecutor<Piloto>
{
    // Método para criar um novo Piloto
    public static void criar(Piloto piloto)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(piloto); // Persiste o Piloto no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar um Piloto existente
    public static void apagar(Piloto piloto)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(piloto); // Remove o Piloto do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar o Piloto
    public static void atualizar(Piloto piloto)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(piloto); // Atualiza o Piloto do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar o Piloto pelo seu ID
    public static Piloto findPiloto(int id)
    {
        return DbConnection.getEntityManager().find(Piloto.class, id); // Retorna o Piloto com o ID fornecido
    }

    // Método para listar todos os Pilotos
    public static List<Piloto> listar()
    {
        return DbConnection.getEntityManager().createQuery("from Piloto ", Piloto.class).getResultList(); // Retorna uma lista de todos os Pilotos
    }
}