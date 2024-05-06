package org.motorsportstats.desktop;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.motorsportstatscore.entity.Notificacao;
import org.motorsportstatscore.entity.Utilizador;

import java.util.Set;

public class NotificacaoCellFactory implements Callback<ListView<String>, ListCell<String>> {

    private final Utilizador utilizadorlogado;

    public NotificacaoCellFactory(Utilizador utilizadorlogado) {
        this.utilizadorlogado = utilizadorlogado;
    }

    @Override
    public ListCell<String> call(ListView<String> listView) {
        return new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // Recupera a notificação correspondente ao item
                    Notificacao notificacao = getNotificacaoFromItem(item);

                    if (notificacao != null) {
                        // Cria elementos de layout para exibir o título e a mensagem da notificação
                        Label tituloLabel = new Label(notificacao.gettituloNotificacao());
                        Label mensagemLabel = new Label(notificacao.getMensagem());

                        // Organiza os elementos de layout
                        VBox container = new VBox(tituloLabel, mensagemLabel);

                        // Define a exibição do item
                        setGraphic(container);
                    }
                }
            }

            // Método para obter a notificação correspondente ao item da ListView
            private Notificacao getNotificacaoFromItem(String item) {
                Set<Notificacao> notificacoes = utilizadorlogado.getNotificacaos();

                // Itera sobre todas as notificações do usuário logado
                for (Notificacao notificacao : notificacoes) {
                    // Verifica se a mensagem da notificação é igual ao item da ListView
                    if (notificacao.getMensagem().equals(item)) {
                        // Se for igual, retorna a notificação correspondente
                        return notificacao;
                    }
                }

                // Se não encontrar a notificação correspondente, retorna null
                return null;
            }
        };
    }
}
