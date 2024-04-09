package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroController
{
    @FXML
    private Button ButCancelarRegistro;
    @FXML
    private TextField nome_usuario;
    @FXML
    private TextField password_usuario;


    @FXML
    private void handleButCancelarRegistro()
    {
        Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarRegistro);
    }

    @FXML
    public String getnome_usuario()
    {
        return nome_usuario.getText();
    }

    @FXML
    public String getpassword_usuario()
    {
        return password_usuario.getText();
    }


}
