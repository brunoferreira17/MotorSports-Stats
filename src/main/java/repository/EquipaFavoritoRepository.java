package repository;

import entity.EquipaFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipaFavoritoRepository extends JpaRepository<EquipaFavorito, Long>, JpaSpecificationExecutor<EquipaFavorito> {

}