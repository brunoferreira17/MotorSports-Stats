package org.motorsportstatscore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EquipaFavoritoId implements Serializable {
    private static final long serialVersionUID = 2675875766221629558L;
    @Column(name = "id_favoritos", nullable = false)
    private Integer idFavoritos;

    @Column(name = "id_equipa", nullable = false)
    private Integer idEquipa;

    public Integer getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Integer idFavoritos) {
        this.idFavoritos = idFavoritos;
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
        EquipaFavoritoId entity = (EquipaFavoritoId) o;
        return Objects.equals(this.idEquipa, entity.idEquipa) &&
                Objects.equals(this.idFavoritos, entity.idFavoritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipa, idFavoritos);
    }

}