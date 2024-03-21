package repository;

import entity.PilotoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PilotoFavoritoRepository extends JpaRepository<PilotoFavorito, Long>, JpaSpecificationExecutor<PilotoFavorito>
{

}