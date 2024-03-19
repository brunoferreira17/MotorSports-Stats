package repository;

import entity.CorridaStages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CorridaStagesRepository extends JpaRepository<CorridaStages, Long>, JpaSpecificationExecutor<CorridaStages> {

}