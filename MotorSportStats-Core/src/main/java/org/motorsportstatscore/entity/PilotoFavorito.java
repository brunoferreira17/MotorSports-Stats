package org.motorsportstatscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "piloto_favoritos")
public class PilotoFavorito {
    @EmbeddedId
    private PilotoFavoritoId id;

    @MapsId("idFavoritos")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_favoritos", nullable = false)
    private Favorito idFavoritos;

    @MapsId("idPiloto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_piloto", nullable = false)
    private Piloto idPiloto;

    public PilotoFavoritoId getId() {
        return id;
    }

    public void setId(PilotoFavoritoId id) {
        this.id = id;
    }

    public Favorito getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Favorito idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public Piloto getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Piloto idPiloto) {
        this.idPiloto = idPiloto;
    }

}