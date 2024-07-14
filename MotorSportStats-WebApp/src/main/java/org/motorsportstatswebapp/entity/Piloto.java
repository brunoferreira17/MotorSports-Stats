package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "piloto")
public class Piloto {
    @Id
    @ColumnDefault("nextval('piloto_id_piloto_seq'::regclass)")
    @Column(name = "id_piloto", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipa", nullable = false)
    private Equipa idEquipa;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @Column(name = "data_nasc", nullable = false)
    private LocalDate dataNasc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipa getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(Equipa idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

}