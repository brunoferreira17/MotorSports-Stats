package org.motorsportstatscore.repository;

import org.motorsportstatscore.entity.Favorito;
import org.motorsportstatscore.entity.Utilizador;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

public interface FavoritoRepository extends JpaRepository<Favorito, Long>, JpaSpecificationExecutor<Favorito> {
    // Método para criar uma novo Favorito
    public static void criar(Favorito favorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(favorito); // Persiste o Favorito no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar um Favorito
    public static void apagar(Favorito favorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(favorito); // Remove o Favorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar o Favorito
    public static void atualizar(Favorito favorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(favorito); // Atualiza o Favorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar o favorito pelo seu ID
    public static Favorito findFavorito(int id) {
        return DbConnection.getEntityManager().find(Favorito.class, id); // Retorna o Favorito com o ID fornecido
    }

    // Método para encontrar os Favoritos pelo ID do Utilizador
    public static Set<Favorito> findFavoritoUtilizador(int id) {
        Utilizador utilizador = DbConnection.getEntityManager().find(Utilizador.class, id);
        return utilizador.getFavoritos();
    }

    // Método para listar todos os Favoritos
    public static List<Favorito> listar() {
        return DbConnection.getEntityManager().createQuery("from Favorito ", Favorito.class).getResultList(); // Retorna uma lista de todos os Favoritos no banco de dados
    }
}