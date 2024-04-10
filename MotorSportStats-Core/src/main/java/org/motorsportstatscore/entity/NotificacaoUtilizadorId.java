package org.motorsportstatscore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NotificacaoUtilizadorId implements Serializable {
    @Serial
    private static final long serialVersionUID = 7492297625962462814L;
    @Column(name = "id_utilizador", nullable = false)
    private Integer idUtilizador;

    @Column(name = "id_notificacao", nullable = false)
    private Integer idNotificacao;

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Integer idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NotificacaoUtilizadorId entity = (NotificacaoUtilizadorId) o;
        return Objects.equals(this.idNotificacao, entity.idNotificacao) &&
                Objects.equals(this.idUtilizador, entity.idUtilizador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotificacao, idUtilizador);
    }

}