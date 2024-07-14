package org.motorsportstatswebapp.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificacao_utilizador")
public class NotificacaoUtilizador {
    @EmbeddedId
    private NotificacaoUtilizadorId id;

    public NotificacaoUtilizadorId getId() {
        return id;
    }

    public void setId(NotificacaoUtilizadorId id) {
        this.id = id;
    }

    //TODO [Reverse Engineering] generate columns from DB
}