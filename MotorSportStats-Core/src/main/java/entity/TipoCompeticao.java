package entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_competicao")
public class TipoCompeticao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_competicao", nullable = false)
    private Integer id;

    @Column(name = "tipo_competicao", length = 50)
    private String tipoCompeticao;

    @OneToMany(mappedBy = "idTipoCompeticao")
    private Set<Competicao> competicaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCompeticao() {
        return tipoCompeticao;
    }

    public void setTipoCompeticao(String tipoCompeticao) {
        this.tipoCompeticao = tipoCompeticao;
    }

    public Set<Competicao> getCompeticaos() {
        return competicaos;
    }

    public void setCompeticaos(Set<Competicao> competicaos) {
        this.competicaos = competicaos;
    }

}