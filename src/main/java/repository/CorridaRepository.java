package repository;

import entity.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CorridaRepository extends JpaRepository<Corrida, Long>, JpaSpecificationExecutor<Corrida> {

}