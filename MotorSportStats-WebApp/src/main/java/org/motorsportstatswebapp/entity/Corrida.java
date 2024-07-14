package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "corrida")
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrida", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_competicao", nullable = false)
    private Competicao idCompeticao;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "local", nullable = false, length = 50)
    private String local;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Competicao getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Competicao idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
