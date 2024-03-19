package repository;

import entity.CorridaVoltas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CorridaVoltasRepository extends JpaRepository<CorridaVoltas, Long>, JpaSpecificationExecutor<CorridaVoltas> {

}