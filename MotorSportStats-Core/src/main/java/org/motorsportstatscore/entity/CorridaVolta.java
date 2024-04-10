package org.motorsportstatscore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "corrida_voltas")
public class CorridaVolta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrida_voltas", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_corrida")
    private Corrida idCorrida;

    @Column(name = "num_voltas")
    private Integer numVoltas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Corrida getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(Corrida idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Integer getNumVoltas() {
        return numVoltas;
    }

    public void setNumVoltas(Integer numVoltas) {
        this.numVoltas = numVoltas;
    }

}