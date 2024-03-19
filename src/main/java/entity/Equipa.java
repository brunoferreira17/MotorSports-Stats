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
}
