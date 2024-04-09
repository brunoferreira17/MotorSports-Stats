package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegistroController
{
    @FXML
    private Button ButCancelarRegistro;

    @FXML
    private void handleButCancelarRegistro()
    {
        Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarRegistro);
    }
}
