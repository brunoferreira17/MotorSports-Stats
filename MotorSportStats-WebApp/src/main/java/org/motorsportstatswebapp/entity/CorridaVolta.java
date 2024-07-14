package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "corrida_voltas")
public class CorridaVolta {
    @Id
    @ColumnDefault("nextval('corrida_voltas_id_corrida_voltas_seq'::regclass)")
    @Column(name = "id_corrida_voltas", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_corrida", nullable = false)
    private Corrida idCorrida;

    @Column(name = "num_voltas", nullable = false)
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