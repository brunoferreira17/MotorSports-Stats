package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "corrida")
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrida", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competicao")
    private Competicao idCompeticao;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "local", length = 50)
    private String local;

    @OneToMany(mappedBy = "idCorrida")
    private Set<CorridaStage> corridaStages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idCorrida")
    private Set<CorridaVolta> corridaVoltas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idCorrida")
    private Set<Resultado> resultados = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Competicao getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Competicao idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Set<CorridaStage> getCorridaStages() {
        return corridaStages;
    }

    public void setCorridaStages(Set<CorridaStage> corridaStages) {
        this.corridaStages = corridaStages;
    }

    public Set<CorridaVolta> getCorridaVoltas() {
        return corridaVoltas;
    }

    public void setCorridaVoltas(Set<CorridaVolta> corridaVoltas) {
        this.corridaVoltas = corridaVoltas;
    }

    public Set<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(Set<Resultado> resultados) {
        this.resultados = resultados;
    }

}