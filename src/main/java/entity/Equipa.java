package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipa")
public class Equipa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipa", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @OneToMany(mappedBy = "id_equipa")
    private Set<EquipaFavorito> equipasFavoritos = new HashSet<>();

    @OneToMany(mappedBy = "id_equipa")
    private Set<EquipaCompeticao> equipaCompeticoes = new HashSet<>();

    @OneToMany(mappedBy = "id_equipa")
    private Set<Piloto> pilotos = new HashSet<>();

    public Long getId() {
        return id;
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

    public Set<EquipaFavorito> getEquipasFavoritos() {
        return equipasFavoritos;
    }

    public void setEquipasFavoritos(Set<EquipaFavorito> equipasFavoritos) {
        this.equipasFavoritos = equipasFavoritos;
    }

    public Set<EquipaCompeticao> getEquipaCompeticoes() {
        return equipaCompeticoes;
    }

    public void setEquipaCompeticoes(Set<EquipaCompeticao> equipaCompeticoes) {
        this.equipaCompeticoes = equipaCompeticoes;
    }

    public Set<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(Set<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
}
