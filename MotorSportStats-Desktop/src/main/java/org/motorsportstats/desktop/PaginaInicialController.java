package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PaginaInicialController
{
    @FXML
    private Button ButRegistrar;
    @FXML
    private Button ButLogin;
    @FXML
    private Label ButFechar;
    @FXML
    private Label avisolabel;

    @FXML
    private void handleButRegistrar()
    {
        Recursos.SceneSwitcher.switchScene("registro.fxml",ButRegistrar);
    }
    @FXML
    private void handleButLogin()
    {
      Recursos.SceneSwitcher.switchScene("login.fxml",ButLogin);
    }
    @FXML
    private void handleButFechar()
    {
        Stage stage = (Stage) ButFechar.getScene().getWindow();
        stage.close();
    }
}
