package repository;

import entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>, JpaSpecificationExecutor<Utilizador> {

}