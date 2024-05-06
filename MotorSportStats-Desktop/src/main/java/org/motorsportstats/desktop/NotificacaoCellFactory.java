package org.motorsportstats.desktop;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.Notificacao;
import org.motorsportstatscore.entity.Utilizador;

public class NotificacaoCellFactory implements Callback<ListView<Notificacao>, ListCell<Notificacao>> {

    private final Utilizador utilizadorLogado;

    public NotificacaoCellFactory(Utilizador utilizadorLogado) {
        this.utilizadorLogado = utilizadorLogado;
    }

    @Override
    public ListCell<Notificacao> call(ListView<Notificacao> listView) {
        return new ListCell<>() {
            @Override
            protected void updateItem(Notificacao notificacao, boolean empty) {
                super.updateItem(notificacao, empty);

                if (empty || notificacao == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // Cria uma VBox para organizar os elementos de layout
                    VBox container = new VBox();
                    container.setAlignment(Pos.CENTER);

                    // Cria uma Label para o título da notificação e a estiliza
                    Label tituloLabel = new Label(notificacao.gettituloNotificacao());
                    tituloLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

                    // Cria uma Label para a mensagem da notificação
                    Label mensagemLabel = new Label(notificacao.getMensagem());

                    // Verifica se a notificação foi marcada como lida
                    boolean notificacaoLida = Funcoes.isNotificacaoLida(notificacao, utilizadorLogado);
                    if (notificacaoLida) {
                        // Se estiver marcada como lida, altera a cor do texto do título para cinza
                        tituloLabel.setStyle("-fx-text-fill: rgb(128,128,128)");
                    } else {
                        // Caso contrário, mantém a cor padrão
                        tituloLabel.setStyle("-fx-text-fill: black;");
                    }

                    // Adiciona um listener de clique à célula de notificação
                    setOnMouseClicked(event -> {
                        if (!notificacaoLida) {
                            Funcoes.MarcarNotificacaoComoLida(notificacao, utilizadorLogado);
                            // Atualiza a cor do texto do título para cinza após marcar como lida
                            tituloLabel.setStyle("-fx-text-fill: rgb(128,128,128)");
                        }
                        // Adicione aqui qualquer outra lógica que deseja executar quando uma notificação é clicada
                    });

                    // Adiciona as Labels à VBox
                    container.getChildren().addAll(tituloLabel, mensagemLabel);

                    // Define a exibição do item
                    setGraphic(container);
                }
            }
        };
    }
}
