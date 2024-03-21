package repository;

import entity.EquipaCompeticao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipaCompeticaoRepository extends JpaRepository<EquipaCompeticao, Long>, JpaSpecificationExecutor<EquipaCompeticao>
{

}