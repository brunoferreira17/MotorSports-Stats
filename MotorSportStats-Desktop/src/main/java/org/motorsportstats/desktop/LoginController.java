package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
    @FXML
    private Button ButConfirmarLogin;
    @FXML
    private Button ButCancelarLogin;
    @FXML
    private TextField email_usuario;
    @FXML
    private PasswordField  password_usuario;

    @FXML
    private void handleButConfirmarLogin()
    {

    }

    @FXML
    private void handleButCancelarLogin()
    {
       Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarLogin);
    }
    @FXML
    public String getemail_usuario()
    {
        return email_usuario.getText();
    }
    @FXML
    public String getpassword_usuario()
    {
        return password_usuario.getText();
    }
}
