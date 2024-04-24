package org.motorsportstatscore.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "corrida")
public class Corrida {

    @Id
    @Column(name = "id_corrida", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCorrida;

    @Column(name = "id_competicao", nullable = false)
    private Integer idCompeticao;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "nome", nullable = false)
    private String nome;

    public void setIdCorrida(Integer idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Integer getIdCorrida() {
        return idCorrida;
    }

    public void setIdCompeticao(Integer idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public Integer getIdCompeticao() {
        return idCompeticao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "idCorrida=" + idCorrida + '\'' +
                "idCompeticao=" + idCompeticao + '\'' +
                "data=" + data + '\'' +
                "local=" + local + '\'' +
                "nome=" + nome + '\'' +
                '}';
    }
}
