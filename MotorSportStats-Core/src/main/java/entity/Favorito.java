package entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "favoritos")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favoritos", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilizador")
    private Utilizador idUtilizador;

    @ManyToMany
    @JoinTable(name = "competicao_favoritos",
            joinColumns = @JoinColumn(name = "id_favoritos"),
            inverseJoinColumns = @JoinColumn(name = "id_competicao"))
    private Set<Competicao> competicaos = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "equipa_favoritos",
            joinColumns = @JoinColumn(name = "id_favoritos"),
            inverseJoinColumns = @JoinColumn(name = "id_equipa"))
    private Set<Equipa> equipas = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "piloto_favoritos",
            joinColumns = @JoinColumn(name = "id_favoritos"),
            inverseJoinColumns = @JoinColumn(name = "id_piloto"))
    private Set<Piloto> pilotos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Set<Competicao> getCompeticaos() {
        return competicaos;
    }

    public void setCompeticaos(Set<Competicao> competicaos) {
        this.competicaos = competicaos;
    }

    public Set<Equipa> getEquipas() {
        return equipas;
    }

    public void setEquipas(Set<Equipa> equipas) {
        this.equipas = equipas;
    }

    public Set<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(Set<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

}