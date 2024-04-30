package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class MiniPaginaAvisoController
{
    @FXML
    private Label LabelOpcao;
    public void SetLabel(String Text)
    {
        LabelOpcao.setText(Text);
    }
    @FXML
    private void handleBotaoConfirmarOpcao()
    {
        LabelOpcao.getScene().getWindow().hide();
    }
}
