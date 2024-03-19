package repository;

import entity.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PilotoRepository extends JpaRepository<Piloto, Long>, JpaSpecificationExecutor<Piloto> {

}