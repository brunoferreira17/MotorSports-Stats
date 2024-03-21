package repository;

import entity.CorridaStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CorridaStagesRepository extends JpaRepository<CorridaStage, Long>, JpaSpecificationExecutor<CorridaStage>
{

}