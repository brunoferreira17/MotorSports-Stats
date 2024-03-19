package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EquipaCompeticaoId implements Serializable {
    private static final long serialVersionUID = 4049361955207001328L;
    @Column(name = "id_competicao", nullable = false)
    private Integer idCompeticao;

    @Column(name = "id_equipa", nullable = false)
    private Integer idEquipa;

    public Integer getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Integer idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public Integer getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Integer idEquipa) {
        this.idEquipa = idEquipa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EquipaCompeticaoId entity = (EquipaCompeticaoId) o;
        return Objects.equals(this.idEquipa, entity.idEquipa) &&
                Objects.equals(this.idCompeticao, entity.idCompeticao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipa, idCompeticao);
    }

}