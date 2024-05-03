package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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


    Utilizador utilizadorlogado = AuthService.getUtilizadorLogado();

    @FXML
    private void handleButNotificacao()
    {
        Set<Notificacao> notificacoes = utilizadorlogado.getNotificacaos();

        for(Notificacao notificacao : notificacoes)
        {
            System.out.println(notificacao.getMensagem());
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


}
