package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.PilotoFavorito;
import org.motorsportstatswebapp.entity.PilotoFavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoFavoritoRepository extends JpaRepository<PilotoFavorito, PilotoFavoritoId> {
}