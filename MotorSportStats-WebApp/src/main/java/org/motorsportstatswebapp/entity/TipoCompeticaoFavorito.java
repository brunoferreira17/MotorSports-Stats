package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_competicao_favorito")
public class TipoCompeticaoFavorito {
    @EmbeddedId
    private TipoCompeticaoFavoritoId id;

    @MapsId("idFavorito")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_favorito", nullable = false)
    private Favorito idFavorito;

    @MapsId("idTipoCompeticao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_competicao", nullable = false)
    private TipoCompeticao idTipoCompeticao;

    public TipoCompeticaoFavoritoId getId() {
        return id;
    }

    public void setId(TipoCompeticaoFavoritoId id) {
        this.id = id;
    }

    public Favorito getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(Favorito idFavorito) {
        this.idFavorito = idFavorito;
    }

    public TipoCompeticao getIdTipoCompeticao() {
        return idTipoCompeticao;
    }

    public void setIdTipoCompeticao(TipoCompeticao idTipoCompeticao) {
        this.idTipoCompeticao = idTipoCompeticao;
    }

}