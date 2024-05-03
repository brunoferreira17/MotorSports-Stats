package org.motorsportstatscore.repository;


import jakarta.persistence.NoResultException;
import org.motorsportstatscore.entity.CompeticaoFavorito;
import org.motorsportstatscore.entity.Favorito;
import org.motorsportstatscore.entity.Utilizador;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;


public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>, JpaSpecificationExecutor<Utilizador> {
    // Método para criar um novo utilizador
    static void criar(Utilizador utilizador) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(utilizador); // Persiste o utilizador no banco de dados
        em.getTransaction().commit();
    }

    // Método para apagar um utilizador existente
    static void apagar(Utilizador utilizador) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(utilizador); // Remove o utilizador do banco de dados
        em.getTransaction().commit();
    }

    // Método para atualizar o Utilizador
    static void atualizar(Utilizador utilizador) {
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.merge(utilizador); // Atualiza o Utilizador do banco de dados
        em.getTransaction().commit();
    }

    // Método para encontrar um utilizador pelo seu ID
    static Utilizador findUtilizador(int id) {
        return DbConnection.getEntityManager().find(Utilizador.class, id); // Retorna o utilizador com o ID fornecido
    }

    // Método para listar todos os utilizadores
   static List<Utilizador> listar() {
        return DbConnection.getEntityManager().createQuery("from Utilizador", Utilizador.class).getResultList(); // Retorna uma lista de todos os utilizadores no banco de dados
    }

    /*public static List<Utilizador> listarWithType(TipoUtilizador TipoUtilizador)
    {
        return DbConnection.getEntityManager().createQuery("from Utilizador ", Utilizador.class).setParameter(1,TypeUtilizador).getResultList();
    }*/

    static Utilizador VerificarAutenticacao(String email, String senha)
    {
        Utilizador utilizador;

        try {
            utilizador = DbConnection.getEntityManager()
                    .createQuery("SELECT u FROM Utilizador u WHERE u.email = :email", Utilizador.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Usuário não encontrado
            return null;
        }

        if (utilizador != null && utilizador.getSenha().equals(senha)) {
            // Senha corresponde
            return utilizador;
        } else {
            // Senha não corresponde
            return null;
        }
    }
}