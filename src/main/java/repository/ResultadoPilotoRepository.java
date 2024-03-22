package repository;

import entity.Resultado;
import entity.ResultadoPiloto;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ResultadoPilotoRepository extends JpaRepository<ResultadoPiloto, Long>, JpaSpecificationExecutor<ResultadoPiloto>
{
    // Método para criar um novo ResultadoPiloto
    public static void criar(ResultadoPiloto resultadopiloto)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(resultadopiloto); // Persiste o ResultadoPiloto no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma Corrida existente
    public static void apagar(ResultadoPiloto resultadopiloto)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(resultadopiloto); // Remove o ResultadoPiloto do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a Corrida
    public static void atualizar(ResultadoPiloto resultadopiloto)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(resultadopiloto); // Atualiza o ResultadoPiloto do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a Corrida pelo seu ID
    public static ResultadoPiloto findResultadoPiloto(int id)
    {
        return DbConnection.getEntityManager().find(ResultadoPiloto.class, id); // Retorna o ResultadoPiloto com o ID fornecido
    }

    // Método para listar todas as Equipas
    public static List<ResultadoPiloto> listar()
    {
        return DbConnection.getEntityManager().createQuery("from ResultadoPiloto", ResultadoPiloto.class).getResultList(); // Retorna uma lista de todas os ResultadosPiloto no banco de dados
    }
}