package org.motorsportstatscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notificacao_utilizador")
public class NotificacaoUtilizador {
    @EmbeddedId
    private NotificacaoUtilizadorId id;

    @MapsId("idUtilizador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilizador", nullable = false)
    private Utilizador idUtilizador;

    @MapsId("idNotificacao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_notificacao", nullable = false)
    private Notificacao idNotificacao;

    public NotificacaoUtilizadorId getId() {
        return id;
    }

    public void setId(NotificacaoUtilizadorId id) {
        this.id = id;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Notificacao getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Notificacao idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

}