package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "competicao")
public class Competicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competicao", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_competicao", nullable = false)
    private TipoCompeticao idTipoCompeticao;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "pais", nullable = false, length = 50)
    private String pais;

    @Column(name = "total_corridas", nullable = false)
    private Integer totalCorridas;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoCompeticao getIdTipoCompeticao() {
        return idTipoCompeticao;
    }

    public void setIdTipoCompeticao(TipoCompeticao idTipoCompeticao) {
        this.idTipoCompeticao = idTipoCompeticao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getTotalCorridas() {
        return totalCorridas;
    }

    public void setTotalCorridas(Integer totalCorridas) {
        this.totalCorridas = totalCorridas;
    }
}
