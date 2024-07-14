package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "resultado_piloto")
public class ResultadoPiloto {
    @EmbeddedId
    private ResultadoPilotoId id;

    @MapsId("idResultado")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_resultado", nullable = false)
    private Resultado idResultado;

    @MapsId("idPiloto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_piloto", nullable = false)
    private Piloto idPiloto;

    public ResultadoPilotoId getId() {
        return id;
    }

    public void setId(ResultadoPilotoId id) {
        this.id = id;
    }

    public Resultado getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Resultado idResultado) {
        this.idResultado = idResultado;
    }

    public Piloto getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Piloto idPiloto) {
        this.idPiloto = idPiloto;
    }

}