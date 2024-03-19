package entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorito", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id")
    private Utilizador utilizador;

    @ManyToMany
    @JoinTable(
            name = "piloto_favorito",
            joinColumns = @JoinColumn(name = "id_favorito"),
            inverseJoinColumns   = @JoinColumn(name = "id_piloto")
    )
    private Set<Piloto> pilotofavorito = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "equipa_favorito",
            joinColumns = @JoinColumn(name = "id_favorito"),
            inverseJoinColumns   = @JoinColumn(name = "id_equipa")
    )
    private Set<Equipa> equipafavorito = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "competicao_favorito",
            joinColumns = @JoinColumn(name = "id_favorito"),
            inverseJoinColumns   = @JoinColumn(name = "id_competicao")
    )
    private Set<Competicao> competicaofavorito = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Set<Piloto> getPilotofavorito() {
        return pilotofavorito;
    }

    public void setPilotofavorito(Set<Piloto> pilotofavorito) {
        this.pilotofavorito = pilotofavorito;
    }

    public Set<Equipa> getEquipafavorito() {
        return equipafavorito;
    }

    public void setEquipafavorito(Set<Equipa> equipafavorito) {
        this.equipafavorito = equipafavorito;
    }

    public Set<Competicao> getCompeticaofavorito() {
        return competicaofavorito;
    }

    public void setCompeticaofavorito(Set<Competicao> competicaofavorito) {
        this.competicaofavorito = competicaofavorito;
    }
}
