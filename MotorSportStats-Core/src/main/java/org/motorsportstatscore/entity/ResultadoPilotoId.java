package org.motorsportstatscore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResultadoPilotoId implements Serializable {
    @Serial
    private static final long serialVersionUID = 6504870555771143145L;
    @Column(name = "id_resultado", nullable = false)
    private Integer idResultado;

    @Column(name = "id_piloto", nullable = false)
    private Integer idPiloto;

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public Integer getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Integer idPiloto) {
        this.idPiloto = idPiloto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResultadoPilotoId entity = (ResultadoPilotoId) o;
        return Objects.equals(this.idPiloto, entity.idPiloto) &&
                Objects.equals(this.idResultado, entity.idResultado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPiloto, idResultado);
    }

}