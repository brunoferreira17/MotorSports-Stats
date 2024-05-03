package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import org.motorsportstatscore.entity.Notificacao;

import java.util.List;
import java.util.Set;

public class NotificacoesController {
    @FXML
    private ListView<String> listaNotificacoes;
    @FXML
    private Label labelSemNotificacoes; // Adiciona o Label aqui

    // Método chamado automaticamente quando o controlador é inicializado
    public void initialize() {
        // Configura a seleção múltipla na lista de notificações
        listaNotificacoes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    // Método para carregar as notificações do usuário atual
    public void carregarNotificacoes(Set<Notificacao> notificacoes) {
        // Limpa a lista antes de carregar as novas notificações para evitar duplicatas
        listaNotificacoes.getItems().clear();

        // Adiciona cada notificação individualmente à lista
        for (Notificacao notificacao : notificacoes) {
            listaNotificacoes.getItems().add(notificacao.getMensagem());
        }

        // Atualiza a visibilidade do Label dependendo se há ou não notificações
        labelSemNotificacoes.setVisible(notificacoes.isEmpty());
        listaNotificacoes.setVisible(!notificacoes.isEmpty());
    }

    // Método para marcar as notificações selecionadas como lidas
    @FXML
    private void marcarComoLidas() {
        MultipleSelectionModel<String> selectionModel = listaNotificacoes.getSelectionModel();
        List<Integer> indicesSelecionados = selectionModel.getSelectedIndices();

        // Implemente a lógica para marcar as notificações selecionadas como lidas
        for (int index : indicesSelecionados) {
            String notificacao = listaNotificacoes.getItems().get(index);
            System.out.println("Notificação marcada como lida: " + notificacao);
            // Aqui você pode remover a notificação da lista ou atualizar seu estado como "lida"
        }

        // Limpa a seleção após marcar como lidas
        selectionModel.clearSelection();
    }
}
