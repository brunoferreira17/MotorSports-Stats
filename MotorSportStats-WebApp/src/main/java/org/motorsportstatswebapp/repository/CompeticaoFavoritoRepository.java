package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.CompeticaoFavorito;
import org.motorsportstatswebapp.entity.CompeticaoFavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompeticaoFavoritoRepository extends JpaRepository<CompeticaoFavorito, CompeticaoFavoritoId> {
}