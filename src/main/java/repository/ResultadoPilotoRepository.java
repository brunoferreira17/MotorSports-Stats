package repository;

import entity.ResultadoPiloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResultadoPilotoRepository extends JpaRepository<ResultadoPiloto, Long>, JpaSpecificationExecutor<ResultadoPiloto>
{

}