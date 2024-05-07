package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.motorsportstatscore.entity.AuthService;
import org.motorsportstatscore.entity.Notificacao;
import org.motorsportstatscore.entity.Utilizador;

import java.util.Set;

public class MenuAdmin
{
    @FXML
    private Button BotaoGerirUtilizadores;
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private ListView<Notificacao> ListaNotificacao;

    Utilizador utilizadorlogado = AuthService.getUtilizadorLogado();

    @FXML
    private void handleButNotificacao()
    {
        if(ListaNotificacao.isVisible())
        {
            ListaNotificacao.setVisible(false);
        } else if (!ListaNotificacao.isVisible())
        {
            ListaNotificacao.setVisible(true);
        }
    }
    @FXML
    private void handleButGerirUtilizadores()
    {
        Recursos.SceneSwitcher.switchScene("AdminGerirUtilizadores.fxml", BotaoGerirUtilizadores);
    }

    @FXML
    private void handleButEditarPerfil()
    {
        Recursos.SceneSwitcher.switchScene("editarperfil.fxml", BotaoEditarPerfil);
    }

    public void initialize()
    {
        // Cria uma instância da NotificacaoCellFactory
        NotificacaoCellFactory cellFactory = new NotificacaoCellFactory(utilizadorlogado);

        // Define a fábrica de células personalizada para a ListView de notificações
        ListaNotificacao.setCellFactory(cellFactory);

        Set<Notificacao> notificacoes = utilizadorlogado.getNotificacaos();

        for (Notificacao notificacao : notificacoes) {
            ListaNotificacao.getItems().add(notificacao);
        }
    }


}
