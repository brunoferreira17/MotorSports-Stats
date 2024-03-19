package repository;

import entity.CompeticaoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompeticaoFavoritoRepository extends JpaRepository<CompeticaoFavorito, Long>, JpaSpecificationExecutor<CompeticaoFavorito> {

}