package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipa_favoritos")
public class EquipaFavorito {
    @EmbeddedId
    private EquipaFavoritoId id;

    @MapsId("idEquipa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipa", nullable = false)
    private Equipa idEquipa;

    @MapsId("idFavoritos")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_favoritos", nullable = false)
    private Favorito idFavoritos;

    public EquipaFavoritoId getId() {
        return id;
    }

    public void setId(EquipaFavoritoId id) {
        this.id = id;
    }

    public Equipa getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Equipa idEquipa) {
        this.idEquipa = idEquipa;
    }

    public Favorito getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Favorito idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

}