package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.motorsportstatscore.entity.AuthService;
import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.NotificacaoRepository;
import org.motorsportstatscore.repository.NotificacaoUtilizadorRepository;

public class MenuAdmin
{
    @FXML
    private Button BotaoGerirUtilizadores;
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private NotificacoesController notificacoesController;

    Utilizador utilizadorlogado = AuthService.getUtilizadorLogado();

    @FXML
    private void handleButNotificacao()
    {
        notificacoesController.carregarNotificacoes(NotificacaoRepository.findNotificacaoUtilizador(utilizadorlogado.getId()));
    }
    @FXML
    private void handleButGerirUtilizadores()
    {
        Recursos.SceneSwitcher.switchScene("AdminGerirUtilizadores.fxml", BotaoGerirUtilizadores);
    }

    @FXML
    private void handleButEditarPerfil()
    {
        Recursos.SceneSwitcher.switchScene("editarperfil.fxml",BotaoEditarPerfil);
    }


}
