package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "notificacao")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao", nullable = false)
    private Integer id;

    @Column(name = "tipo_notificacao", length = 250)
    private String tipoNotificacao;

    @Column(name = "mensagem", length = 250)
    private String mensagem;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    @ManyToMany
    @JoinTable(name = "notificacao_utilizador",
            joinColumns = @JoinColumn(name = "id_notificacao"),
            inverseJoinColumns = @JoinColumn(name = "id_utilizador"))
    private Set<Utilizador> utilizadors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Set<Utilizador> getUtilizadors() {
        return utilizadors;
    }

    public void setUtilizadors(Set<Utilizador> utilizadors) {
        this.utilizadors = utilizadors;
    }

}