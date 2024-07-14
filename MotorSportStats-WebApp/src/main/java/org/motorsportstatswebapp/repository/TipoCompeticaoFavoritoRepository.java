package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.TipoCompeticaoFavorito;
import org.motorsportstatswebapp.entity.TipoCompeticaoFavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCompeticaoFavoritoRepository extends JpaRepository<TipoCompeticaoFavorito, TipoCompeticaoFavoritoId> {
}