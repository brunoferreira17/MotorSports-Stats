package org.motorsportstatscore.repository;

import org.motorsportstatscore.entity.Piloto;
import org.motorsportstatscore.entity.PilotoFavorito;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PilotoFavoritoRepository extends JpaRepository<PilotoFavorito, Long>, JpaSpecificationExecutor<PilotoFavorito> {
    // Método para criar um novo Piloto
    public static void criar(Piloto pilotofavorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(pilotofavorito); // Persiste o Piloto no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar um PilotoFavorito existente
    public static void apagar(PilotoFavorito pilotofavorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(pilotofavorito); // Remove o PilotoFavorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar o PilotoFavorito
    public static void atualizar(PilotoFavorito pilotofavorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(pilotofavorito); // Atualiza o PilotoFavorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar o PilotoFavorito pelo seu ID
    public static PilotoFavorito findPilotoFavorito(int id) {
        return DbConnection.getEntityManager().find(PilotoFavorito.class, id); // Retorna o PilotoFavorito com o ID fornecido
    }

    // Método para listar todos os Pilotos
    public static List<PilotoFavorito> listar() {
        return DbConnection.getEntityManager().createQuery("from PilotoFavorito ", PilotoFavorito.class).getResultList(); // Retorna uma lista de todos os Pilotos
    }
}