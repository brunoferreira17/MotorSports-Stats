package entity;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizador", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_utilizador")
    private TipoUtilizador tipo;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "senha", nullable = false, length = 12)
    private String senha;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "telefone", nullable = false, length = 20)
    private Long telefone;

    @Column(name = "data_nasc", nullable = false)
    private Date data_nasc;

    @ManyToMany
    @JoinTable(
            name = "notificacao_utilizador",
            joinColumns = @JoinColumn(name = "id_utilizador"),
            inverseJoinColumns = @JoinColumn(name = "id_notificacao")
    )
    private Set<Notificacao> notificacoes = new HashSet<>();

    @OneToMany(mappedBy = "utilizador")
    private Set<Favorito> favoritos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoUtilizador getTipo() {
        return tipo;
    }

    public void setTipo(TipoUtilizador tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Set<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(Set<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

    public Set<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Favorito> favoritos) {
        this.favoritos = favoritos;
    }
}

