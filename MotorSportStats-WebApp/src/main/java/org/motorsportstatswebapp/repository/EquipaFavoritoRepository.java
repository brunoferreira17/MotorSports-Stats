package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.EquipaFavorito;
import org.motorsportstatswebapp.entity.EquipaFavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipaFavoritoRepository extends JpaRepository<EquipaFavorito, EquipaFavoritoId> {
}