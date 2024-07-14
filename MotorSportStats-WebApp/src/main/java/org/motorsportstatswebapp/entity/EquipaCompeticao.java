package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipa_competicao")
public class EquipaCompeticao {
    @EmbeddedId
    private EquipaCompeticaoId id;

    @MapsId("idEquipa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipa", nullable = false)
    private Equipa idEquipa;

    @MapsId("idCompeticao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_competicao", nullable = false)
    private Competicao idCompeticao;

    public EquipaCompeticaoId getId() {
        return id;
    }

    public void setId(EquipaCompeticaoId id) {
        this.id = id;
    }

    public Equipa getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Equipa idEquipa) {
        this.idEquipa = idEquipa;
    }

    public Competicao getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Competicao idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

}