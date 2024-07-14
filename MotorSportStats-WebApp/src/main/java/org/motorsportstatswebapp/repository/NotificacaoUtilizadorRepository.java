package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.NotificacaoUtilizador;
import org.motorsportstatswebapp.entity.NotificacaoUtilizadorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoUtilizadorRepository extends JpaRepository<NotificacaoUtilizador, NotificacaoUtilizadorId> {
}