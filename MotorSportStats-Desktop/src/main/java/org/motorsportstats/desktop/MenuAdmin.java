package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuAdmin
{
    @FXML
    private Button BotaoGerirUtilizadores;
    @FXML
    private Button BotaoEditarPerfil;


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
