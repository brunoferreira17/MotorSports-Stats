package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "utilizador")
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizador", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "senha", length = 12)
    private String senha;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "idUtilizador")
    private Set<Favorito> favoritos = new LinkedHashSet<>();
    @ManyToMany
    @JoinTable(name = "notificacao_utilizador",
            joinColumns = @JoinColumn(name = "id_utilizador"),
            inverseJoinColumns = @JoinColumn(name = "id_notificacao"))
    private Set<Notificacao> notificacaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public Set<Notificacao> getNotificacaos() {
        return notificacaos;
    }

    public void setNotificacaos(Set<Notificacao> notificacaos) {
        this.notificacaos = notificacaos;
    }

/*
 TODO [JPA Buddy] create field to map the 'tipo' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "tipo", columnDefinition = "tipo_utilizador(0, 0)")
    private Object tipo;
*/
}