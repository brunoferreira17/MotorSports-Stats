package org.motorsportstatswebapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notificacao")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao", nullable = false)
    private Integer id;

    @Column(name = "mensagem", nullable = false, length = 250)
    private String mensagem;

    @Column(name = "data_envio", nullable = false)
    private LocalDate dataEnvio;

    @Column(name = "titulo_notificacao", length = 250)
    private String tituloNotificacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTituloNotificacao() {
        return tituloNotificacao;
    }

    public void setTituloNotificacao(String tituloNotificacao) {
        this.tituloNotificacao = tituloNotificacao;
    }

}