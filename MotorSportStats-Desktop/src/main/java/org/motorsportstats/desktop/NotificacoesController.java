package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import org.motorsportstatscore.entity.Notificacao;

import java.util.List;
import java.util.Set;

public class NotificacoesController
{
    @FXML
    private ListView<String> listaNotificacoes;

    public void initialize() {
        // Configuração da seleção múltipla para permitir que o usuário selecione várias notificações
        listaNotificacoes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void carregarNotificacoes(Set<Notificacao> notificacoes) {
        listaNotificacoes.getItems().addAll(notificacoes);
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
