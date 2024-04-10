package org.motorsportstatscore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompeticaoFavoritoId implements Serializable {
    @Serial
    private static final long serialVersionUID = -8164431525389361455L;
    @Column(name = "id_favoritos", nullable = false)
    private Integer idFavoritos;

    @Column(name = "id_competicao", nullable = false)
    private Integer idCompeticao;

    public Integer getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Integer idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public Integer getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Integer idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompeticaoFavoritoId entity = (CompeticaoFavoritoId) o;
        return Objects.equals(this.idFavoritos, entity.idFavoritos) &&
                Objects.equals(this.idCompeticao, entity.idCompeticao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavoritos, idCompeticao);
    }

}