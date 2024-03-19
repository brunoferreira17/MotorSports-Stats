package repository;

import entity.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FavoritoRepository extends JpaRepository<Favorito, Long>, JpaSpecificationExecutor<Favorito> {

}