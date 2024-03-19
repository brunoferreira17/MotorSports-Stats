package repository;

import entity.NotificacaoUtilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificacaoUtilizadorRepository extends JpaRepository<NotificacaoUtilizador, Long>, JpaSpecificationExecutor<NotificacaoUtilizador> {

}