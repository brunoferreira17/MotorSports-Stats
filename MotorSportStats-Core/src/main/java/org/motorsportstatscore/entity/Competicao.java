package org.motorsportstatscore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "competicao")
public class Competicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competicao", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_competicao")
    private TipoCompeticao idTipoCompeticao;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "pais", length = 50)
    private String pais;

    @Column(name = "total_corridas")
    private Integer totalCorridas;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_competicao"),
            inverseJoinColumns = @JoinColumn(name = "id_favoritos"))
    private Set<Favorito> favoritos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idCompeticao")
    private Set<Corrida> corridas = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "equipa_competicao",
            joinColumns = @JoinColumn(name = "id_competicao"),
            inverseJoinColumns = @JoinColumn(name = "id_equipa"))
    private Set<Equipa> equipas = new LinkedHashSet<>();

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

    public Set<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public Set<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(Set<Corrida> corridas) {
        this.corridas = corridas;
    }

    public Set<Equipa> getEquipas() {
        return equipas;
    }

    public void setEquipas(Set<Equipa> equipas) {
        this.equipas = equipas;
    }

}