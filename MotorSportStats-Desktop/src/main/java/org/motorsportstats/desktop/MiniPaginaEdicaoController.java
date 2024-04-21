package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MiniPaginaEdicaoController {
    @FXML
    private Label LabelOpcao;
    @FXML
    private TextField TextoEdicao;
    private String novoOpcao;

    public void SetLabel(String Text)
    {
        LabelOpcao.setText(Text);
    }

    @FXML
    private void handleBotaoConfirmarOpcao()
    {
        novoOpcao = TextoEdicao.getText();
        fecharJanela();
    }

    public String getNovoOpcao()
    {
        return novoOpcao;
    }

    private void fecharJanela()
    {
        TextoEdicao.getScene().getWindow().hide();
    }
}
