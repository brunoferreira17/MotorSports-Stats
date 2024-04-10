package org.motorsportstatscore.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipa")
public class Equipa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipa", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "nacionalidade", length = 50)
    private String nacionalidade;

    @ManyToMany
    @JoinTable(name = "equipa_competicao",
            joinColumns = @JoinColumn(name = "id_equipa"),
            inverseJoinColumns = @JoinColumn(name = "id_competicao"))
    private Set<Competicao> competicaos = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_equipa"),
            inverseJoinColumns = @JoinColumn(name = "id_favoritos"))
    private Set<Favorito> favoritos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEquipa")
    private Set<Piloto> pilotos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Competicao> getCompeticaos() {
        return competicaos;
    }

    public void setCompeticaos(Set<Competicao> competicaos) {
        this.competicaos = competicaos;
    }

    public Set<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public Set<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(Set<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

}