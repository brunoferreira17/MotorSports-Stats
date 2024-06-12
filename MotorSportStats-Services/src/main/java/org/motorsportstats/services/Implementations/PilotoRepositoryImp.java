package org.motorsportstats.services.Implementations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.motorsportstatscore.entity.Piloto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PilotoRepositoryImp {

    @PersistenceContext
    private EntityManager entityManager;

    public void criar(Piloto piloto) {
        entityManager.persist(piloto);
    }

    public void apagar(Piloto piloto) {
        entityManager.remove(piloto);
    }

    public void atualizar(Piloto piloto) {
        entityManager.merge(piloto);
    }

    public Piloto findPiloto(int id) {
        return entityManager.find(Piloto.class, id);
    }

    public List<Piloto> listar() {
        return entityManager.createQuery("FROM Piloto", Piloto.class).getResultList();
    }
}
