package org.motorsportstatswebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TipoCompeticaoFavoritoId implements Serializable {
    private static final long serialVersionUID = 6092609025156235941L;
    @Column(name = "id_favorito", nullable = false)
    private Integer idFavorito;

    @Column(name = "id_tipo_competicao", nullable = false)
    private Integer idTipoCompeticao;

    public Integer getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(Integer idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Integer getIdTipoCompeticao() {
        return idTipoCompeticao;
    }

    public void setIdTipoCompeticao(Integer idTipoCompeticao) {
        this.idTipoCompeticao = idTipoCompeticao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TipoCompeticaoFavoritoId entity = (TipoCompeticaoFavoritoId) o;
        return Objects.equals(this.idFavorito, entity.idFavorito) &&
                Objects.equals(this.idTipoCompeticao, entity.idTipoCompeticao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavorito, idTipoCompeticao);
    }

}