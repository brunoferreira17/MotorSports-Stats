package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DesportoController
{
    @FXML
    private Button botaoAoVivo;
    @FXML
    private void handleButbotaoAoVivo()
    {
        Recursos.SceneSwitcher.switchScene("inicio_aovivo.fxml",botaoAoVivo);
    }

}