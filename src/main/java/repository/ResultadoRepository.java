package repository;

import entity.Corrida;
import entity.Resultado;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Long>, JpaSpecificationExecutor<Resultado>
{
    // Método para criar um novo Resultado
    public static void criar(Resultado resultado)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(resultado); // Persiste o Resultado no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma Corrida existente
    public static void apagar(Resultado resultado)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(resultado); // Remove o Resultado do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a Corrida
    public static void atualizar(Resultado resultado)
    {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(resultado); // Atualiza o Resultado do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a Corrida pelo seu ID
    public static Resultado findResultado(int id)
    {
        return DbConnection.getEntityManager().find(Resultado.class, id); // Retorna o Resultado com o ID fornecido
    }

    // Método para listar todas as Equipas
    public static List<Resultado> listar()
    {
        return DbConnection.getEntityManager().createQuery("from Resultado", Resultado.class).getResultList(); // Retorna uma lista de todas os Resultados no banco de dados
    }
}