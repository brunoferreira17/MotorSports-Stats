package repository;

import entity.Equipa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipaRepository extends JpaRepository<Equipa, Long>, JpaSpecificationExecutor<Equipa> {

}