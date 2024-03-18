package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "favoritos")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favoritos", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id_utilizador")
    private Utilizador utilizador;

    @OneToMany(mappedBy = "id_favoritos")
    private Set<piloto_favoritos> piloto_favoritos = new HashSet<>();
}
