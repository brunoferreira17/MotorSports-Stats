package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "corrida")
public class Corrida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_corrida", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorrida;

    @Column(name = "id_competicao", nullable = false)
    private Long idCompeticao;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "nome", nullable = false)
    private String nome;

    public void setIdCorrida(Long idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Long getIdCorrida() {
        return idCorrida;
    }

    public void setIdCompeticao(Long idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public Long getIdCompeticao() {
        return idCompeticao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Corrida{" +
                "idCorrida=" + idCorrida + '\'' +
                "idCompeticao=" + idCompeticao + '\'' +
                "data=" + data + '\'' +
                "local=" + local + '\'' +
                "nome=" + nome + '\'' +
                '}';
    }
}
