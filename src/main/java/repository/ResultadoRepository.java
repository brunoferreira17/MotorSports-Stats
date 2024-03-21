package repository;

import entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResultadoRepository extends JpaRepository<Resultado, Long>, JpaSpecificationExecutor<Resultado>
{


}