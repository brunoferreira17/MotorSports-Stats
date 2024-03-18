package entity;

import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"notificacao\"")
public class notificao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_notificacao\"", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
}
