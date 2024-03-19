package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "corrida_stages")
public class CorridaStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrida_stages", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_corrida")
    private Corrida idCorrida;

    @Column(name = "num_stages")
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