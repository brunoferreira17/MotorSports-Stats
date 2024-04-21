package repository;

import entity.TipoCompeticaoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoCompeticaoFavoritoRepository extends JpaRepository<TipoCompeticaoFavorito, Long>, JpaSpecificationExecutor<TipoCompeticaoFavorito> {

}