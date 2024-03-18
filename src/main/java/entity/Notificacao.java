package entity;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao", nullable = false)
    private Long id;

    @Column(name = "tipo_notificacao", nullable = false, length = 50)
    private String tipo_notificacao;

    @Column(name = "mensagem", nullable = false, length = 250)
    private String mensagem;

    @Column(name = "data_envio", nullable = false)
    private Date data_envio;

    @ManyToMany(mappedBy = "notificacoes")
    private Set<Utilizador> utilizadores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_notificacao() {
        return tipo_notificacao;
    }

    public void setTipo_notificacao(String tipo_notificacao) {
        this.tipo_notificacao = tipo_notificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData_envio() {
        return data_envio;
    }

    public void setData_envio(Date data_envio) {
        this.data_envio = data_envio;
    }

    public Set<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(Set<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }
}