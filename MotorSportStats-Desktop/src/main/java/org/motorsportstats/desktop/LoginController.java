package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController
{
    @FXML
    private Button ButConfirmarLogin;
    @FXML
    private Button ButCancelarLogin;

    @FXML
    private void handleButConfirmarLogin()
    {

    }

    @FXML
    private void handleButCancelarLogin()
    {
       Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarLogin);
    }
}
