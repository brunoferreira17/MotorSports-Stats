package entity;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "piloto")
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @Column(name = "data_nasc", nullable = false)
    private Date data_nasc;

    @ManyToOne
    @JoinColumn(name = "id_equipa")
    private Equipa equipa;

    @OneToMany(mappedBy = "id_piloto")
    private Set<PilotoFavorito> pilotosFavoritos = new HashSet<>();
}
