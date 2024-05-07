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
                    VBox container = new VBox();
                    container.setAlignment(Pos.CENTER);

                    Label tituloLabel = new Label(notificacao.gettituloNotificacao());
                    tituloLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

                    Label mensagemLabel = new Label(notificacao.getMensagem());

                    boolean notificacaoLida = Funcoes.isNotificacaoLida(notificacao, utilizadorLogado);
                    if (notificacaoLida)
                    {
                        tituloLabel.setStyle("-fx-text-fill: rgb(128,128,128)");
                    } else
                    {
                        tituloLabel.setStyle("-fx-text-fill: black;");
                    }

                    setOnMouseClicked(event -> {
                        if (!notificacaoLida) {
                            Funcoes.MarcarNotificacaoComoLida(notificacao, utilizadorLogado);
                            tituloLabel.setStyle("-fx-text-fill: rgb(128,128,128)");
                        }
                    });

                    container.getChildren().addAll(tituloLabel, mensagemLabel);

                    setGraphic(container);
                }
            }
        };
    }
}
