package entity;

import javax.persistence.*;

@Entity
@Table(name = "notificacao_utilizador")
public class NotificacaoUtilizador {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id", updatable = false)
    private Utilizador utilizador;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_notificacao", referencedColumnName = "id", updatable = false)
    private Notificacao notificacao;
}
