package org.motorsportstatscore.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "piloto")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipa")
    private Equipa idEquipa;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "nacionalidade", length = 50)
    private String nacionalidade;

    @Column(name = "idade")
    private Integer idade;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_piloto"),
            inverseJoinColumns = @JoinColumn(name = "id_favoritos"))
    private Set<Favorito> favoritos = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "resultado_piloto",
            joinColumns = @JoinColumn(name = "id_piloto"),
            inverseJoinColumns = @JoinColumn(name = "id_resultado"))
    private Set<Resultado> resultados = new LinkedHashSet<>();

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Set<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public Set<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(Set<Resultado> resultados) {
        this.resultados = resultados;
    }

}