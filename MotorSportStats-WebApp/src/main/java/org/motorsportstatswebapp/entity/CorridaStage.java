package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "corrida_stages")
public class CorridaStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrida_stages", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_corrida", nullable = false)
    private Corrida idCorrida;

    @Column(name = "num_stages", nullable = false)
    private Integer numStages;

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

    public Integer getNumStages() {
        return numStages;
    }

    public void setNumStages(Integer numStages) {
        this.numStages = numStages;
    }

}