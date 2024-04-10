package org.motorsportstatscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "competicao_favoritos")
public class CompeticaoFavorito {
    @EmbeddedId
    private CompeticaoFavoritoId id;

    @MapsId("idFavoritos")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_favoritos", nullable = false)
    private Favorito idFavoritos;

    @MapsId("idCompeticao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_competicao", nullable = false)
    private Competicao idCompeticao;

    public CompeticaoFavoritoId getId() {
        return id;
    }

    public void setId(CompeticaoFavoritoId id) {
        this.id = id;
    }

    public Favorito getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Favorito idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public Competicao getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Competicao idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

}