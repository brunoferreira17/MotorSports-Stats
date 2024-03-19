package repository;

import entity.CorridaVolta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CorridaVoltasRepository extends JpaRepository<CorridaVolta, Long>, JpaSpecificationExecutor<CorridaVolta> {

}