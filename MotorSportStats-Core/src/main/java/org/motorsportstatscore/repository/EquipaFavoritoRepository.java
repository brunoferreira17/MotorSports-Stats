package org.motorsportstatscore.repository;

import org.motorsportstatscore.entity.EquipaFavorito;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EquipaFavoritoRepository extends JpaRepository<EquipaFavorito, Long>, JpaSpecificationExecutor<EquipaFavorito> {
    // Método para criar uma nova EquipaFavorito
    public static void criar(EquipaFavorito equipafavorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(equipafavorito); // Persiste a EquipaFavorito no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar uma EquipaFavorito existente
    public static void apagar(EquipaFavorito equipafavorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(equipafavorito); // Remove a EquipaFavorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar a EquipaFavorito
    public static void atualizar(EquipaFavorito equipafavorito) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(equipafavorito); // Atualiza a EquipaFavorito do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar a EquipaFavorito pelo seu ID
    public static EquipaFavorito findEquipaFavorito(int id) {
        return DbConnection.getEntityManager().find(EquipaFavorito.class, id); // Retorna a EquipaFavorito com o ID fornecido
    }

    // Método para listar todas as EquipaFavorito
    public static List<EquipaFavorito> listar() {
        return DbConnection.getEntityManager().createQuery("from EquipaFavorito ", EquipaFavorito.class).getResultList(); // Retorna uma lista de todas as EquipaFavorito no banco de dados
    }

}