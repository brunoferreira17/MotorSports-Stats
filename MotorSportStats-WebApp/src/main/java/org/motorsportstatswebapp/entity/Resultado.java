package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "resultado")
public class Resultado {
    @Id
    @ColumnDefault("nextval('resultado_id_resultado_seq'::regclass)")
    @Column(name = "id_resultado", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_corrida", nullable = false)
    private Corrida idCorrida;

    @Column(name = "posicao", nullable = false)
    private Integer posicao;

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

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

/*
 TODO [Reverse Engineering] create field to map the 'tempo' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "tempo", columnDefinition = "interval")
    private Object tempo;
*/
}