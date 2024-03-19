package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PilotoFavoritoId implements Serializable {
    private static final long serialVersionUID = -7490426369126992160L;
    @Column(name = "id_favoritos", nullable = false)
    private Integer idFavoritos;

    @Column(name = "id_piloto", nullable = false)
    private Integer idPiloto;

    public Integer getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Integer idFavoritos) {
        this.idFavoritos = idFavoritos;
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
        PilotoFavoritoId entity = (PilotoFavoritoId) o;
        return Objects.equals(this.idFavoritos, entity.idFavoritos) &&
                Objects.equals(this.idPiloto, entity.idPiloto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavoritos, idPiloto);
    }

}